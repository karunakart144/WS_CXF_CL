package com.igate.service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import documentservices.wms0.rbcfg.servicemessage.Application;
import documentservices.wms0.rbcfg.servicemessage.DocumentServiceRequest;
import documentservices.wms0.rbcfg.servicemessage.DocumentServices;
import documentservices.wms0.rbcfg.servicemessage.MetaDataField;
import documentservices.wms0.rbcfg.servicemessage.MetaDataFields;
import documentservices.wms0.rbcfg.servicemessage.ObjectFactory;
import documentservices.wms0.rbcfg.servicemessage.UserAuthRequest;

//Thread safe utility class
public class DocumentServicesHelper {

	
	public enum TransactionTypeEnum {SEARCH , GETCONTENT, STORAGE, AddINDEX, REMOVEINDEX, UPDATEINDEX};
	
	static ObjectFactory of = new ObjectFactory();
	
	/*<DocumentServices xmlns="http://RBCFG.WMS0.DocumentServices/ServiceMessage">
    <UserAuthRequest>
        <UserID>999999999</UserID>
        <UserRole>SuperUser</UserRole>
        <Application>
            <ApplicationCode>SXL0</ApplicationCode>
            <LanguageCode>EN</LanguageCode>
        </Application>
    </UserAuthRequest>
    <DocumentServiceRequest>
        <TransactionGUID>61FB065F-4701-440F-9771-78052A3253C4</TransactionGUID>
        <TransactionType>1</TransactionType>
        <TransactionDescription>Search</TransactionDescription>
        <TransactionDate>2014-12-18</TransactionDate>
        <TransactionTime>18:00:00</TransactionTime>
        <IncludeDocumentImage>false</IncludeDocumentImage>
        <MetaDataFields>
            <MetaDataField Value="BTS20100602-1120AM" Name="PolicyNumber"/>
        </MetaDataFields>
    </DocumentServiceRequest>
</DocumentServices>*/
	
	public static DocumentServices createDocumentRequest(){
		
		DocumentServices req = of.createDocumentServices();
		UserAuthRequest userAuthRequest = of.createUserAuthRequest();
		req.setUserAuthRequest(userAuthRequest);
		
		Application app = of.createApplication();
		app.setApplicationCode("SXL0");
		app.setLanguageCode("EN");
		userAuthRequest.setApplication(app);
		
		DocumentServiceRequest documentServiceRequest = of.createDocumentServiceRequest();
		req.setDocumentServiceRequest(documentServiceRequest);
		
		documentServiceRequest.setTransactionGUID(UUID.randomUUID().toString());

		Date dNow = new Date();
		SimpleDateFormat dateFT = new SimpleDateFormat("yyyy-MM-dd");
		documentServiceRequest.setTransactionDate(dateFT.format(dNow));
		
		SimpleDateFormat timeFT = new SimpleDateFormat("hh:mm:ss");
		documentServiceRequest.setTransactionTime(timeFT.format(dNow));
		
		documentServiceRequest.setIncludeDocumentImage(false);
		MetaDataFields metaDataFields = of.createMetaDataFields();
		documentServiceRequest.setMetaDataFields(metaDataFields);
		
		return req;
	}
	
	public static DocumentServices setUser(DocumentServices req, String user, String role){
		req.getUserAuthRequest().setUserID(user);
		req.getUserAuthRequest().setUserRole(role);
		
		return req;
	}
	
	
	public static DocumentServices addMetaData(DocumentServices req, String name, String value){
		MetaDataField metaDataField = of.createMetaDataField();
		metaDataField.setName(name);
		metaDataField.setValue(value);
		req.getDocumentServiceRequest().getMetaDataFields().getMetaDataField().add(metaDataField);
		
		return req;
	}

	public static DocumentServices setTransactionType(DocumentServices req, TransactionTypeEnum tranType){
		if(tranType == TransactionTypeEnum.SEARCH){
			req.getDocumentServiceRequest().setTransactionType("1");
			req.getDocumentServiceRequest().setTransactionDescription("Search");
		} else if(tranType == TransactionTypeEnum.GETCONTENT){
			req.getDocumentServiceRequest().setTransactionType("7");
			req.getDocumentServiceRequest().setTransactionDescription("Get Content");
		} else if(tranType == TransactionTypeEnum.STORAGE){
			req.getDocumentServiceRequest().setTransactionType("8");
			req.getDocumentServiceRequest().setTransactionDescription("Storage");
		} else if(tranType == TransactionTypeEnum.AddINDEX){
			req.getDocumentServiceRequest().setTransactionType("9");
			req.getDocumentServiceRequest().setTransactionDescription("Add Index");
		} else if(tranType == TransactionTypeEnum.REMOVEINDEX){
			req.getDocumentServiceRequest().setTransactionType("10");
			req.getDocumentServiceRequest().setTransactionDescription("Remove Index");
		} else if(tranType == TransactionTypeEnum.UPDATEINDEX){
			req.getDocumentServiceRequest().setTransactionType("11");
			req.getDocumentServiceRequest().setTransactionDescription("Update Index");
		}
		
		return req;
	}
	

}
