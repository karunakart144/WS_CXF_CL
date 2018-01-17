package documentservices.wms0.rbcfg.serviceClient;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.log4j.Logger;
import org.jvnet.staxex.StreamingDataHandler;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.bind.JAXB;
import javax.xml.rpc.ServiceException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.MTOMFeature;

//import com.sun.xml.ws.developer.JAXWSProperties;
//import com.sun.xml.ws.developer.StreamingDataHandler;

import documentservices.wms0.rbcfg.servicemessage.DocumentServices;
import documentservices.wms0.rbcfg.servicemessage.Document;
import documentservices.wms0.rbcfg.servicemessage.MetaDataField;

public class ServiceClientTestServlet extends HttpServlet {
	static Logger log = Logger.getLogger(ServiceClientTestServlet.class);
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tptype = request.getParameter("TransactionType");
		String ttype = "7";
		DocumentServicesClient docClient = new DocumentServicesClient();
		Map staticValues = new HashMap();
		staticValues.put("UserID", "XXXXXXXXXX");
		staticValues.put("UserRole", "N/A");
		staticValues.put("ApplicationCode", "SXL0");
		staticValues.put("LanguageCode", "EN");
		staticValues.put("TransactionGUID","8c49ea64-d395-425f-b69a-192d0c903ddd");
		staticValues.put("TransactionDate", "01/12/2015");
		staticValues.put("TransactionTime", "12:25:18");
		staticValues.put("IncludeDocumentImage", "false");

		Map metaFieldsMap = new HashMap();
		
		if("1".equals(ttype)){
			//search
			staticValues.put("TransactionType", "1");
			staticValues.put("TransactionDescription", "Search");
			
			metaFieldsMap.put("PolicyNumber", "N0922122014");
			//metaFieldsMap.put("DocType", "NB");
			//metaFieldsMap.put("DocSubType", "APSAu");
			
		}else if("7".equals(ttype)){
			//getContent
			staticValues.put("TransactionType", "7");
			staticValues.put("TransactionDescription", "Get Content");
			
			metaFieldsMap.put("DocGUID", "0a107ba2-1737-4e6a-a020-e7a741319785");
		}
		

		javax.xml.ws.Holder<DocumentServices> clientResponse = null;
		try {
			clientResponse = docClient.serviceCall(staticValues, metaFieldsMap);
		} catch (UnrecoverableKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (KeyManagementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (KeyStoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CertificateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		StringWriter strWriter = new StringWriter();
		//clientResponse.value.getDocumentServiceRequest().getContent().setObjectContent(null);
		JAXB.marshal(clientResponse.value, strWriter);
		String xmlStr = strWriter.toString();
		log.info("xmlStr......"+xmlStr);
			
						PrintWriter out = response.getWriter();
						out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\n"
								+ "<html> \n"
								+ "<head> \n"
								+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n"
								+ "<title> Mtom jsp  </title> \n"
								+ "</head> \n"
								+ "<body> \n"
								+ "<font size=\"4px\" \">"
								+ "Response from the service is "
								+ " \n"
								+strWriter.toString()
								+ "</font> \n"
								+ "<font size=\"4px\" \">"
								+ "Response from the service is "+xmlStr
								+ " \n"
								+strWriter.toString()
								+ "</font> \n"
								+ "</body> \n"
								+ "</html>");
					}
}