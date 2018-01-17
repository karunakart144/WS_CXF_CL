package com.mtom.servlet;

import java.net.HttpURLConnection;
import java.net.URL;

public class TestServletClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	    URL gwtServlet = null;
	    try {
	    	DocumentServices req = DocumentServicesHelper.createDocumentRequest();
			req = DocumentServicesHelper.setUser(req, "999999999", "SuperUser");
			req = DocumentServicesHelper.setTransactionType(req, DocumentServicesHelper.TransactionTypeEnum.SEARCH);
			req = DocumentServicesHelper.addMetaData(req, "PolicyNumber", "BTS20100602-1120AM");
			
			
	        gwtServlet = new URL("http://RDWLHSWFWDEV:9876/Web_Service_Client/DocumentContent?UserID=999999999&&UserRole=SuperUser&&");
	        HttpURLConnection servletConnection = (HttpURLConnection) gwtServlet.openConnection();
	        servletConnection.setRequestMethod("POST");
	        
	        servletConnection.setDoOutput(true);

	        ObjectOutputStream objOut = new ObjectOutputStream(servletConnection.getOutputStream());
	        objOut.writeObject(p);
	        objOut.flush();
	        objOut.close();

	    } catch (MalformedURLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	}

}
