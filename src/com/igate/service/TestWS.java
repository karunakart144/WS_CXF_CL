package com.igate.service;
import java.io.StringWriter;

import javax.xml.bind.JAXB;
import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import documentservices.wms0.rbcfg.servicemessage.BizTalkServiceInstance;
import documentservices.wms0.rbcfg.servicemessage.DocumentServices;
import documentservices.wms0.rbcfg.servicemessage.WMS0DSWebServiceBTOrcCoreProcessDocumentServicePortRcvSndDSMessage;


public class TestWS {
	static Logger log = Logger.getLogger(TestWS.class);
	public static void main(String ... args){
		try{
			
			
			DocumentServices req = DocumentServicesHelper.createDocumentRequest();
			req = DocumentServicesHelper.setUser(req, "999999999", "SuperUser");
			req = DocumentServicesHelper.setTransactionType(req, DocumentServicesHelper.TransactionTypeEnum.SEARCH);
			req = DocumentServicesHelper.addMetaData(req, "PolicyNumber", "BTS20100602-1120AM");
			
			BizTalkServiceInstance docService = new BizTalkServiceInstance();
			WMS0DSWebServiceBTOrcCoreProcessDocumentServicePortRcvSndDSMessage docServer = docService
					.getCustomBindingITwoWayAsync();
			BindingProvider provider = (BindingProvider) docServer;
			
			//DocumentSSLHelper.configureSSL(provider);
			
			StringWriter strWriter = new StringWriter();
			JAXB.marshal(req, strWriter);
			log.info(".....serviceRequest is ........" + strWriter.toString());
			
			javax.xml.ws.Holder<DocumentServices> _opRcvSndDSMessage_part = new javax.xml.ws.Holder<DocumentServices>(req);
			docServer.opRcvSndDSMessage(_opRcvSndDSMessage_part);
			
			StringWriter strWriterResp = new StringWriter();
			JAXB.marshal(_opRcvSndDSMessage_part.value, strWriterResp);
			log.info(".....serviceResponse is ........" + strWriterResp.toString());
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
