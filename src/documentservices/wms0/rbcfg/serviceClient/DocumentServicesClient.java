package documentservices.wms0.rbcfg.serviceClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.xml.bind.JAXB;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import com.sun.xml.ws.developer.JAXWSProperties;

import documentservices.wms0.rbcfg.servicemessage.Application;
import documentservices.wms0.rbcfg.servicemessage.BizTalkServiceInstance;
import documentservices.wms0.rbcfg.servicemessage.Content;
import documentservices.wms0.rbcfg.servicemessage.DocumentServiceRequest;
import documentservices.wms0.rbcfg.servicemessage.DocumentServices;
import documentservices.wms0.rbcfg.servicemessage.MetaDataField;
import documentservices.wms0.rbcfg.servicemessage.MetaDataFields;
import documentservices.wms0.rbcfg.servicemessage.ObjectFactory;
import documentservices.wms0.rbcfg.servicemessage.UserAuthRequest;
import documentservices.wms0.rbcfg.servicemessage.WMS0DSWebServiceBTOrcCoreProcessDocumentServicePortRcvSndDSMessage;

//import DocumentServices.WMS0.RBCFG.ServiceMessage.holders.DocumentServicesHolder;

public class DocumentServicesClient {
	final static ObjectFactory of = new ObjectFactory();
	static Logger log = Logger.getLogger(DocumentServicesClient.class);

	public Holder<DocumentServices> serviceCall(
			Map<String, String> staticValues, Map<String, String> metaFieldsMap) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException, KeyManagementException {
		log.info("In client program for accessing the service ");
		BizTalkServiceInstance docService = new BizTalkServiceInstance();
		WMS0DSWebServiceBTOrcCoreProcessDocumentServicePortRcvSndDSMessage docServer = docService
				.getCustomBindingITwoWayAsync();
		BindingProvider provider = (BindingProvider) docServer;

		// provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
		// "http://localhost:8787/test");

		/*SSLContext ctx = SSLContext.getInstance("TLS");
		KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		KeyStore ks = KeyStore.getInstance("JKS");
		char[] passphrase = "password".toCharArray();
		ks.load(new FileInputStream("E:\\Dev\\TwoWaySSL_test\\rbc1.keystore"),
				passphrase);
		kmf.init(ks, passphrase);
		ctx.init(kmf.getKeyManagers(), null, null);

		// ---------------------------------

		Map<String, Object> reqCtx = provider.getRequestContext();

		reqCtx.put(JAXWSProperties.SSL_SOCKET_FACTORY, ctx.getSocketFactory());
		reqCtx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"https://wsie0.sterbc.com:443/mmws/ib/SXL0-LightHouse-SDF/services");*/

		SOAPBinding soapBinding = (SOAPBinding) provider.getBinding();
		soapBinding.setMTOMEnabled(true);
		try {

			DocumentServices req = of.createDocumentServices();
			UserAuthRequest userAuth = of.createUserAuthRequest();

			String value = getMapValue(staticValues, "UserID");
			userAuth.setUserID(value == null ? "SYSTEM" : value);

			value = getMapValue(staticValues, "UserRole");
			userAuth.setUserRole(value == null ? "NA" : value);

			Application app = of.createApplication();

			app.setApplicationCode("SXL0");

			value = getMapValue(staticValues, "LanguageCode");
			app.setLanguageCode(value == null ? "EN" : value);
			userAuth.setApplication(app);

			DocumentServiceRequest docRequestType = of
					.createDocumentServiceRequest();

			value = getMapValue(staticValues, "TransactionGUID");
			if (value == null) {
				log.error("TransactionGUID is mandatory. space assumed.");
				value = "";
			}
			docRequestType.setTransactionGUID(value);

			value = getMapValue(staticValues, "TransactionType");
			if (value == null) {
				log.error("Invalid TransactionType value " + value);
				throw new RuntimeException("Invalid TransactionType value "
						+ value);
			}

			docRequestType.setTransactionType(value);

			value = getTransctionDesc(value);
			log.info(" TransactionType Description is " + value);
			docRequestType.setTransactionDescription(value);

			value = getMapValue(staticValues, "TransactionDate");
			if (value == null) {
				Date dNow = new Date();
				SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd");
				log.error("TransactionDate is mandatory. Current date is assumed.");
				value = ft1.format(dNow);
			}
			docRequestType.setTransactionDate(value);

			value = getMapValue(staticValues, "TransactionTime");
			if (value == null) {
				Date dNow = new Date();
				SimpleDateFormat ft1 = new SimpleDateFormat("hh:mm:ss");
				log.error("TransactionTime is mandatory. Current time is assumed.");
				value = ft1.format(dNow);
			}
			docRequestType.setTransactionTime(value);

			docRequestType.setIncludeDocumentImage(getMapValue(staticValues,
					"IncludeDocumentImage").equalsIgnoreCase("false") ? false
					: true);

			MetaDataFields mdfields = of.createMetaDataFields();

			// Packages reqPkgs = of.createPackages();
			// Package reqPkg = of.createPackage();
			// Documents reqDocs = of.createDocuments();
			// Document reqDoc = of.createDocument();
			Content imageContent = of.createContent();

			if ("8".equals(getMapValue(staticValues, "TransactionType"))) {// Storage
				value = getMapValue(staticValues, "objectContent");
				if (value == null) {
					log.error("objectContent not provided for  TransactionType = 8 i.e. Storage");
					throw new RuntimeException(
							"objectContent not provided for  TransactionType = 8 i.e. Storage");
				}

				log.info("Attempting to read file " + value);

				// Reading a Image file from file system
				DataSource source = new FileDataSource(new File(value));
				imageContent.setObjectContent(new DataHandler(source));

				value = getMapValue(staticValues, "objectMimeType");
				if (value != null) {
					if (value.equalsIgnoreCase("image/tiff"))
						imageContent.setObjectMimeType("image/tiff");
					else if (value.equalsIgnoreCase("application/pdf"))
						imageContent.setObjectMimeType("application/pdf");
					else {
						log.error("Invalid objectMimeType = " + value);
						throw new RuntimeException("Invalid objectMimeType = "
								+ value);
					}
				} else {
					log.error("Invalid objectMimeType = " + value);
					throw new RuntimeException("Invalid objectMimeType = "
							+ value);
				}

				docRequestType.setContent(imageContent);
			}
			if ("1".equals(getMapValue(staticValues, "TransactionType"))) {
				if (!metaFieldsMap.containsKey("PolicyNumber")) {
					log.error("Required Fields Are Missing In The Search Request");
					throw new RuntimeException(
							"Required Fields Are Missing In The Search Request");
				}
			} else if ("7".equals(getMapValue(staticValues, "TransactionType"))) {
				if (!metaFieldsMap.containsKey("DocGUID")) {
					log.error("Required Fields Are Missing In The Get Content Request");
					throw new RuntimeException(
							"Required Fields Are Missing In The Get Content Request");
				}
			} else if ("8".equals(getMapValue(staticValues, "TransactionType"))
					|| "9".equals(getMapValue(staticValues, "TransactionType"))
					|| "10".equals(getMapValue(staticValues, "TransactionType"))
					|| "11".equals(getMapValue(staticValues, "TransactionType"))) {
				if (!metaFieldsMap.containsKey("PolicyNumber")
						|| !metaFieldsMap.containsKey("ClientName")
						|| !metaFieldsMap.containsKey("DocType")
						|| !metaFieldsMap.containsKey("DocType")) {
					log.error("Required Fields Are Missing In The  Request");
					throw new RuntimeException(
							"Required Fields Are Missing In The Request");
				}
			}

			Properties multiValueProps = new Properties();
			multiValueProps.load(new FileInputStream("C:\\Users\\kt820384\\Documents\\properties\\multiValue.properties"));

			if ("11".equals(getMapValue(staticValues, "TransactionType"))) {// Update
																			// index
				for (Entry<String, String> e : metaFieldsMap.entrySet()) {
					StringTokenizer st = new StringTokenizer(e.getValue(), "+");
					while (st.hasMoreElements()) {
						MetaDataField mdfield = of.createMetaDataField();
						mdfield.setName(e.getKey());
						mdfield.setValue((String) st.nextElement());
						mdfields.getMetaDataField().add(mdfield);
					}
				}
			} else {
				for (Entry<String, String> e : metaFieldsMap.entrySet()) {

					if (multiValueProps.containsKey(e.getKey())) {
						// log.info("multi value key --> "+e.getKey()+"....value is "+e.getValue());
						StringTokenizer st = new StringTokenizer(e.getValue(),
								"+");
						while (st.hasMoreElements()) {
							MetaDataField mdfield = of.createMetaDataField();
							mdfield.setName(e.getKey());
							mdfield.setValue((String) st.nextElement());
							mdfields.getMetaDataField().add(mdfield);
						}
					} else {
						// log.info("not a multi value key --> "+e.getKey()+"....value is "+e.getValue());
						MetaDataField mdfield = of.createMetaDataField();
						mdfield.setName(e.getKey());
						mdfield.setValue(e.getValue());
						mdfields.getMetaDataField().add(mdfield);
					}
				}
			}

			// reqDoc.setMetaDataFields(mdfields);
			// reqDocs.getDocument().add(reqDoc);
			// reqPkg.setDocuments(reqDocs);
			// reqPkgs.getPackage().add(reqPkg);
			// docRequestType.setPackages(reqPkgs);
			docRequestType.setMetaDataFields(mdfields);
			req.setUserAuthRequest(userAuth);
			req.setDocumentServiceRequest(docRequestType);

			// just for testing purpose .... to see the request
			StringWriter strWriter = new StringWriter();
			JAXB.marshal(req, strWriter);
			log.info(".....serviceRequest is ........" + strWriter.toString());
			// String serviceResponse =
			// docServer.serviceRequest(strWriter.toString());

			// DocumentServicesHolder holder = new DocumentServicesHolder(req);
			javax.xml.ws.Holder<documentservices.wms0.rbcfg.servicemessage.DocumentServices> _opRcvSndDSMessage_part = new javax.xml.ws.Holder<documentservices.wms0.rbcfg.servicemessage.DocumentServices>(
					req);
			docServer.opRcvSndDSMessage(_opRcvSndDSMessage_part);

			// just for testing purpose .... to see the response
			// StringWriter responseWriter = new StringWriter();
			// JAXB.marshal(_opRcvSndDSMessage_part.value, responseWriter);
			// log.info(".....serviceResponse is ........" +
			// responseWriter.toString());
			// return responseWriter.toString();
			return _opRcvSndDSMessage_part;
		} catch (Exception e) {
			log.error("Encountered Exception" + e);
			throw new RuntimeException(e);
		}
	}

	public String getMapValue(Map<String, String> m, String key) {
		return m.get(key);
	}

	public String getTransctionDesc(String type) {

		if (type.equals("1"))
			return "Search";

		if (type.equals("7"))
			return "Get Content";

		if (type.equals("8"))
			return "Storage";

		if (type.equals("9"))
			return "Add Index";

		if (type.equals("10"))
			return "Remove Index";

		if (type.equals("11"))
			return "Update Index";

		return "";
	}
}
