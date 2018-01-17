package documentservices.wms0.rbcfg.servicemessage;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.rpc.ServiceException;

import org.jvnet.staxex.StreamingDataHandler;


public class TestServiceClient {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ServiceException {
		
		DocumentServerClient docClient = new DocumentServerClient();
		Map staticValues = new HashMap();
		staticValues.put("UserID", "XXXXXXXXXX");
		staticValues.put("UserRole", "N/A");
		staticValues.put("ApplicationCode", "SXL0");
		staticValues.put("LanguageCode", "EN");
		staticValues.put("TransactionGUID","8c49ea64-d395-425f-b69a-192d0c903ddd");
		//staticValues.put("TransactionType", "1");
		//staticValues.put("TransactionDescription", "Search");
		
		staticValues.put("TransactionType", "7");
		staticValues.put("TransactionDescription", "Get Content");
		
		//staticValues.put("TransactionType", "8");
		//staticValues.put("TransactionDescription", "Storage");
		
		//staticValues.put("TransactionType", "9");
		//staticValues.put("TransactionDescription", "Add Index");
				
		//staticValues.put("TransactionType", "10");
		//staticValues.put("TransactionDescription", "Remove Index");
		
		//staticValues.put("TransactionType", "11");
		//staticValues.put("TransactionDescription", "Update Index");
		
		staticValues.put("TransactionDate", "01/12/2015");
		staticValues.put("TransactionTime", "12:25:18");
		staticValues.put("IncludeDocumentImage", "false");

		Map metaFieldsMap = new HashMap();
		
		//search
		//metaFieldsMap.put("PolicyNumber", "N0922122014");
		//metaFieldsMap.put("ClientName", "KARUNAKAR, REDDY 11");
		//metaFieldsMap.put("DocSubType", "APSAu");
		
		//getContent
		metaFieldsMap.put("DocGUID", "0a107ba2-1737-4e6a-a020-e7a741319785");
		
		//Storage
		//metaFieldsMap.put("PolicyNumber", "N00000321");
		//metaFieldsMap.put("ClientName", "KARUNAKAR, REDDY 03_12012015");
		//metaFieldsMap.put("DocType", "NB");
		//metaFieldsMap.put("DocSubType", "APSAu");
		//staticValues.put("objectMimeType", "image/tiff");
		//staticValues.put("objectContent", "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert_Tiff.tif");
		
		//remove multiple index
		//metaFieldsMap.put("PolicyNumber", "N0922122014");
		//metaFieldsMap.put("DocGUID", "58905c7e-855b-417c-91dc-30f01a8507fa");
		
		//add mulitple index
		//metaFieldsMap.put("PolicyNumber", "N0922122014");
		//metaFieldsMap.put("DocGUID", "58905c7e-855b-417c-91dc-30f01a8507fa");
		
		//update mulitple index
		//metaFieldsMap.put("PolicyNumber", "N0522122014,U0522122014");
		//metaFieldsMap.put("DocGUID", "4f28cb19-a0ff-4c94-b466-0d7c07a8856a");
		
				
		//String response = docClient.serviceCall(staticValues, metaFieldsMap);
		//System.out.println("response value is "+response);
		
		javax.xml.ws.Holder<DocumentServices> clientResponse = null;
		try {
			clientResponse = docClient.serviceCall(staticValues, metaFieldsMap);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			//getContent
			for (Document d : clientResponse.value.getDocumentServiceResponse().getDocuments().getDocument()) {
				DataHandler dhandler = d.getContent().getObjectContent();
				StreamingDataHandler sdhandler = (StreamingDataHandler) dhandler;
				File file = new File("C://Users//Public//Pictures//Sample Pictures//Desert_tiff_one.tif");
				try {
					
					sdhandler.moveTo(file);
					sdhandler.close();
					/*InputStream is = dhandler.getInputStream(); // DataHandler
					OutputStream os = new FileOutputStream(file);

					byte[] buffer = new byte[1024];
					int bytesRead =0;
					while ((bytesRead = is.read(buffer)) != -1)
					{
					    os.write(buffer, 0, bytesRead);
					}
					os.flush();
					os.close();*/
				} catch (Exception e) {
					e.printStackTrace();
				}
				//Create a DataSource from an image 
		        //File file = new File(imageResourceDir+File.separator+"test.jpg");
		        ImageInputStream fiis = new FileImageInputStream(new File("C://Users//Public//Pictures//Sample Pictures//Desert_tiff_one.tif"));
		        Image image = ImageIO.read(fiis);
		      //display it in frame
			    JFrame frame = new JFrame();
			    frame.setSize(300, 300);
			    JLabel label = new JLabel(new ImageIcon(image));
			    frame.add(label);
			    frame.setVisible(true);
		
			}
		}
}
