package com.mtom.servlet;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
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
import javax.xml.rpc.ServiceException;

import org.jvnet.staxex.StreamingDataHandler;

import documentservices.wms0.rbcfg.servicemessage.DocumentServices;
import documentservices.wms0.rbcfg.servicemessage.Document;
import documentservices.wms0.rbcfg.servicemessage.MetaDataField;

public class ServiceClientTestServlet extends HttpServlet { 
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  {
	  String ttype = request.getParameter("TransactionType");
	  DocumentServerClientToServlet docClient = new DocumentServerClientToServlet();
	  
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
		}else if("8".equals(ttype)){
			//Storage
			staticValues.put("TransactionType", "8");
			staticValues.put("TransactionDescription", "Storage");
			staticValues.put("objectMimeType", "image/tiff");
			staticValues.put("objectContent", "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert_Tiff.tif");
			
			metaFieldsMap.put("PolicyNumber", "N00000321");
			metaFieldsMap.put("ClientName", "KARUNAKAR, REDDY 03_12012015");
			metaFieldsMap.put("DocType", "NB");
			metaFieldsMap.put("DocSubType", "APSAu");
			
		}else if("9".equals(ttype)){
			//add mulitple index
			staticValues.put("TransactionType", "9");
			staticValues.put("TransactionDescription", "Add Index");
			
			metaFieldsMap.put("PolicyNumber", "N00000321");
			metaFieldsMap.put("DocType", "NB");
			metaFieldsMap.put("DocSubType", "APSAu");
			metaFieldsMap.put("DocGUID", "58905c7e-855b-417c-91dc-30f01a8507fa");
		}else if("10".equals(ttype)){
			//remove multiple index
			staticValues.put("TransactionType", "10");
			staticValues.put("TransactionDescription", "Remove Index");

			metaFieldsMap.put("PolicyNumber", "N00000321");
			metaFieldsMap.put("DocType", "NB");
			metaFieldsMap.put("DocSubType", "APSAu");
			metaFieldsMap.put("DocGUID", "58905c7e-855b-417c-91dc-30f01a8507fa");
		}else if("11".equals(ttype)){
			//update mulitple index
			staticValues.put("TransactionType", "11");
			staticValues.put("TransactionDescription", "Update Index");
			
			metaFieldsMap.put("PolicyNumber", "N00000321");
			metaFieldsMap.put("DocType", "NB");
			metaFieldsMap.put("DocSubType", "APSAu");
			metaFieldsMap.put("DocGUID", "58905c7e-855b-417c-91dc-30f01a8507fa");;
		}
		
		
		
		
		
		
				
		javax.xml.ws.Holder<DocumentServices> clientResponse = null;
		try {
			clientResponse = docClient.serviceCall(staticValues, metaFieldsMap);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if("7".equals(ttype)){
			//getContent
			for (Document d : clientResponse.value.getDocumentServiceResponse().getDocuments().getDocument()) {
				DataHandler dhandler = d.getContent().getObjectContent();
				//StreamingDataHandler sdhandler = (StreamingDataHandler) dhandler;
				File file = new File("C://Users//Public//Pictures//Sample Pictures//Desert_tiff_one.tif");
				try {
					
					//sdhandler.moveTo(file);
					//sdhandler.close();
					InputStream is = dhandler.getInputStream(); // DataHandler
					OutputStream os = new FileOutputStream(file);

					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = is.read(buffer)) != -1)
					{
					    os.write(buffer, 0, bytesRead);
					}
					os.flush();
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				//Create a DataSource from an image 
		        //File file = new File(imageResourceDir+File.separator+"test.jpg");
		        ImageInputStream fiis = new FileImageInputStream(file);
		        Image image = ImageIO.read(fiis);
		      //display it in frame
			    JFrame frame = new JFrame();
			    frame.setSize(300, 300);
			    JLabel label = new JLabel(new ImageIcon(image));
			    frame.add(label);
			    frame.setVisible(true);
			}
			
		    
		}else {
			int resultCode = clientResponse.value.getDocumentServiceResponse().getTransactionResult().getResultCode();
			String resultDescription = clientResponse.value.getDocumentServiceResponse().getTransactionResult().getResultDescription();
			for (Document d : clientResponse.value.getDocumentServiceResponse().getDocuments().getDocument()) {
				for (MetaDataField m : d.getMetaDataFields().getMetaDataField()) {
					if (m.getName().equalsIgnoreCase("DocGUID")) {
						PrintWriter out = response.getWriter();
					    out.println (
					    		"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\n" +
					      "<html> \n" +
					        "<head> \n" +
					          "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
					          "<title> Mtom jsp  </title> \n" +
					        "</head> \n" +
					        "<body> \n" +
					          "<font size=\"12px\" \">" +
					          m.getName() +"......"+m.getValue()+"\n"+
					          "Result Code is "+resultCode+" \n"+
					          "Result Description is "+resultDescription+" \n"+
					          "</font> \n" +
					        "</body> \n" +
					      "</html>" 
					    ); 
					}
				}
			}
		}
		

    System.out.println("MtomStreamingService  Download Successful!");
  }  
}