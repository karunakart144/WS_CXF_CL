
package documentservices.wms0.rbcfg.servicemessage;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the documentservices.wms0.rbcfg.servicemessage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TransactionGUID_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "TransactionGUID");
    private final static QName _TransactionType_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "TransactionType");
    private final static QName _TransactionDescription_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "TransactionDescription");
    private final static QName _TransactionDate_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "TransactionDate");
    private final static QName _TransmittalMethod_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "TransmittalMethod");
    private final static QName _ObjectMimeType_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "objectMimeType");
    private final static QName _URL_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "URL");
    private final static QName _TransactionTime_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "TransactionTime");
    private final static QName _IncludeDocumentImage_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "IncludeDocumentImage");
    private final static QName _ResultCode_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "ResultCode");
    private final static QName _FaxNumber_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "FaxNumber");
    private final static QName _Name_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "Name");
    private final static QName _ObjectContent_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "objectContent");
    private final static QName _ResultDescription_QNAME = new QName("http://RBCFG.WMS0.DocumentServices/ServiceMessage", "ResultDescription");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: documentservices.wms0.rbcfg.servicemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DocumentServices }
     * 
     */
    public DocumentServices createDocumentServices() {
        return new DocumentServices();
    }

    /**
     * Create an instance of {@link UserAuthRequest }
     * 
     */
    public UserAuthRequest createUserAuthRequest() {
        return new UserAuthRequest();
    }

    /**
     * Create an instance of {@link Application }
     * 
     */
    public Application createApplication() {
        return new Application();
    }

    /**
     * Create an instance of {@link DocumentServiceRequest }
     * 
     */
    public DocumentServiceRequest createDocumentServiceRequest() {
        return new DocumentServiceRequest();
    }

    /**
     * Create an instance of {@link MetaDataFields }
     * 
     */
    public MetaDataFields createMetaDataFields() {
        return new MetaDataFields();
    }

    /**
     * Create an instance of {@link MetaDataField }
     * 
     */
    public MetaDataField createMetaDataField() {
        return new MetaDataField();
    }

    /**
     * Create an instance of {@link Content }
     * 
     */
    public Content createContent() {
        return new Content();
    }

    /**
     * Create an instance of {@link Packages }
     * 
     */
    public Packages createPackages() {
        return new Packages();
    }

    /**
     * Create an instance of {@link Package }
     * 
     */
    public Package createPackage() {
        return new Package();
    }

    /**
     * Create an instance of {@link Recipients }
     * 
     */
    public Recipients createRecipients() {
        return new Recipients();
    }

    /**
     * Create an instance of {@link Recipient }
     * 
     */
    public Recipient createRecipient() {
        return new Recipient();
    }

    /**
     * Create an instance of {@link Documents }
     * 
     */
    public Documents createDocuments() {
        return new Documents();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link UserAuthResponse }
     * 
     */
    public UserAuthResponse createUserAuthResponse() {
        return new UserAuthResponse();
    }

    /**
     * Create an instance of {@link TransactionResult }
     * 
     */
    public TransactionResult createTransactionResult() {
        return new TransactionResult();
    }

    /**
     * Create an instance of {@link DocumentServiceResponse }
     * 
     */
    public DocumentServiceResponse createDocumentServiceResponse() {
        return new DocumentServiceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "TransactionGUID")
    public JAXBElement<String> createTransactionGUID(String value) {
        return new JAXBElement<String>(_TransactionGUID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "TransactionType")
    public JAXBElement<String> createTransactionType(String value) {
        return new JAXBElement<String>(_TransactionType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "TransactionDescription")
    public JAXBElement<String> createTransactionDescription(String value) {
        return new JAXBElement<String>(_TransactionDescription_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "TransactionDate")
    public JAXBElement<String> createTransactionDate(String value) {
        return new JAXBElement<String>(_TransactionDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "TransmittalMethod")
    public JAXBElement<String> createTransmittalMethod(String value) {
        return new JAXBElement<String>(_TransmittalMethod_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "objectMimeType")
    public JAXBElement<String> createObjectMimeType(String value) {
        return new JAXBElement<String>(_ObjectMimeType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "URL")
    public JAXBElement<String> createURL(String value) {
        return new JAXBElement<String>(_URL_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "TransactionTime")
    public JAXBElement<String> createTransactionTime(String value) {
        return new JAXBElement<String>(_TransactionTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "IncludeDocumentImage")
    public JAXBElement<Boolean> createIncludeDocumentImage(Boolean value) {
        return new JAXBElement<Boolean>(_IncludeDocumentImage_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "ResultCode")
    public JAXBElement<Integer> createResultCode(Integer value) {
        return new JAXBElement<Integer>(_ResultCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "FaxNumber")
    public JAXBElement<String> createFaxNumber(String value) {
        return new JAXBElement<String>(_FaxNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "Name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataHandler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "objectContent")
    @XmlMimeType("*/*")
    public JAXBElement<DataHandler> createObjectContent(DataHandler value) {
        return new JAXBElement<DataHandler>(_ObjectContent_QNAME, DataHandler.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://RBCFG.WMS0.DocumentServices/ServiceMessage", name = "ResultDescription")
    public JAXBElement<String> createResultDescription(String value) {
        return new JAXBElement<String>(_ResultDescription_QNAME, String.class, null, value);
    }

}
