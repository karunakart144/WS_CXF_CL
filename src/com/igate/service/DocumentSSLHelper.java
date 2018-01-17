package com.igate.service;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Map;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import javax.net.ssl.SSLContext;

import org.apache.log4j.Logger;

import com.sun.xml.internal.ws.developer.JAXWSProperties;

import documentservices.wms0.rbcfg.servicemessage.BizTalkServiceInstance;
import documentservices.wms0.rbcfg.servicemessage.WMS0DSWebServiceBTOrcCoreProcessDocumentServicePortRcvSndDSMessage;

public class DocumentSSLHelper {
	static Logger log = Logger.getLogger(DocumentSSLHelper.class);
	public static void configureSSL(BindingProvider provider) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, UnrecoverableKeyException, KeyManagementException{
		
		SSLContext ctx = SSLContext.getInstance("TLS");
		KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		KeyStore ks = KeyStore.getInstance("JKS");
		char[] passphrase = "password".toCharArray();
		InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("rbc1.keystore");
		ks.load(input, passphrase);
		kmf.init(ks, passphrase);
		ctx.init(kmf.getKeyManagers(), null, null);

		SSLSocketFactory factory = ctx.getSocketFactory();
		SSLSocket socket = (SSLSocket) factory.createSocket(
				"wsie0.sterbc.com", 443);
		socket.startHandshake();
		SOAPBinding soapBinding = (SOAPBinding) provider.getBinding();
		soapBinding.setMTOMEnabled(true);

		Map<String, Object> reqCtx = provider.getRequestContext();
		reqCtx.put(JAXWSProperties.SSL_SOCKET_FACTORY, factory);
		reqCtx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"https://wsie0.sterbc.com:443/mmws/ib/SXL0-LightHouse-SDF/services");
	}
}
