package com.igate.service;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import documentservices.wms0.rbcfg.servicemessage.BizTalkServiceInstance;
import documentservices.wms0.rbcfg.servicemessage.DocumentServices;
import documentservices.wms0.rbcfg.servicemessage.WMS0DSWebServiceBTOrcCoreProcessDocumentServicePortRcvSndDSMessage;

/**
 * Servlet implementation class DocumentContent
 */
public class DocumentContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DocumentContent.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DocumentContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			DocumentServices req = DocumentServicesHelper.createDocumentRequest();
			req = DocumentServicesHelper.setUser(req, request.getParameter("UserID").toString(), request.getParameter("UserRole").toString());
			
			String transactionType = request.getParameter("TransactionType").toString();
			if(transactionType.equals("1")){
				req = DocumentServicesHelper.setTransactionType(req,DocumentServicesHelper.TransactionTypeEnum.SEARCH);
			}else if(transactionType.equals("7")){
				req = DocumentServicesHelper.setTransactionType(req,DocumentServicesHelper.TransactionTypeEnum.GETCONTENT);
			}else if(transactionType.equals("8")){
				req = DocumentServicesHelper.setTransactionType(req,DocumentServicesHelper.TransactionTypeEnum.STORAGE);
			}else if(transactionType.equals("10")){
				req = DocumentServicesHelper.setTransactionType(req,DocumentServicesHelper.TransactionTypeEnum.AddINDEX);
			}else if(transactionType.equals("11")){
				req = DocumentServicesHelper.setTransactionType(req,DocumentServicesHelper.TransactionTypeEnum.REMOVEINDEX);
			}else if(transactionType.equals("12")){
				req = DocumentServicesHelper.setTransactionType(req,DocumentServicesHelper.TransactionTypeEnum.UPDATEINDEX);
			}
			
			
			req = DocumentServicesHelper.addMetaData(req, "PolicyNumber",request.getParameter("PolicyNumber").toString());

			BizTalkServiceInstance docService = new BizTalkServiceInstance();
			WMS0DSWebServiceBTOrcCoreProcessDocumentServicePortRcvSndDSMessage docServer = docService
					.getCustomBindingITwoWayAsync();
			BindingProvider provider = (BindingProvider) docServer;

			DocumentSSLHelper.configureSSL(provider);
			SOAPBinding soapBinding = (SOAPBinding) provider.getBinding();
			soapBinding.setMTOMEnabled(true);
			
			StringWriter strWriter = new StringWriter();
			JAXB.marshal(req, strWriter);
			log.info(".....serviceRequest is ........" + strWriter.toString());

			javax.xml.ws.Holder<DocumentServices> _opRcvSndDSMessage_part = new javax.xml.ws.Holder<DocumentServices>(
					req);
			docServer.opRcvSndDSMessage(_opRcvSndDSMessage_part);

			StringWriter strWriterResp = new StringWriter();
			JAXB.marshal(_opRcvSndDSMessage_part.value, strWriterResp);
			log.info(".....serviceResponse is ........"
					+ strWriterResp.toString());
			System.out.println(strWriterResp.toString());
			request.setAttribute("responsefrom", strWriterResp.toString());
			//request.getRequestDispatcher("Response.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
