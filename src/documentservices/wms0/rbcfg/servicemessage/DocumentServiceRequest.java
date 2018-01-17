
package documentservices.wms0.rbcfg.servicemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}TransactionGUID"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}TransactionType"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}TransactionDescription"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}TransactionDate"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}TransactionTime"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}IncludeDocumentImage" minOccurs="0"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}MetaDataFields" minOccurs="0"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}Content" minOccurs="0"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}Packages" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transactionGUID",
    "transactionType",
    "transactionDescription",
    "transactionDate",
    "transactionTime",
    "includeDocumentImage",
    "metaDataFields",
    "content",
    "packages"
})
@XmlRootElement(name = "DocumentServiceRequest")
public class DocumentServiceRequest {

    @XmlElement(name = "TransactionGUID", required = true)
    protected String transactionGUID;
    @XmlElement(name = "TransactionType", required = true)
    protected String transactionType;
    @XmlElement(name = "TransactionDescription", required = true)
    protected String transactionDescription;
    @XmlElement(name = "TransactionDate", required = true)
    protected String transactionDate;
    @XmlElement(name = "TransactionTime", required = true)
    protected String transactionTime;
    @XmlElement(name = "IncludeDocumentImage")
    protected Boolean includeDocumentImage;
    @XmlElement(name = "MetaDataFields")
    protected MetaDataFields metaDataFields;
    @XmlElement(name = "Content")
    protected Content content;
    @XmlElement(name = "Packages")
    protected Packages packages;

    /**
     * Gets the value of the transactionGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionGUID() {
        return transactionGUID;
    }

    /**
     * Sets the value of the transactionGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionGUID(String value) {
        this.transactionGUID = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the transactionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionDescription() {
        return transactionDescription;
    }

    /**
     * Sets the value of the transactionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionDescription(String value) {
        this.transactionDescription = value;
    }

    /**
     * Gets the value of the transactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionDate(String value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the transactionTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionTime() {
        return transactionTime;
    }

    /**
     * Sets the value of the transactionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionTime(String value) {
        this.transactionTime = value;
    }

    /**
     * Gets the value of the includeDocumentImage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeDocumentImage() {
        return includeDocumentImage;
    }

    /**
     * Sets the value of the includeDocumentImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeDocumentImage(Boolean value) {
        this.includeDocumentImage = value;
    }

    /**
     * Gets the value of the metaDataFields property.
     * 
     * @return
     *     possible object is
     *     {@link MetaDataFields }
     *     
     */
    public MetaDataFields getMetaDataFields() {
        return metaDataFields;
    }

    /**
     * Sets the value of the metaDataFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaDataFields }
     *     
     */
    public void setMetaDataFields(MetaDataFields value) {
        this.metaDataFields = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link Content }
     *     
     */
    public Content getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link Content }
     *     
     */
    public void setContent(Content value) {
        this.content = value;
    }

    /**
     * Gets the value of the packages property.
     * 
     * @return
     *     possible object is
     *     {@link Packages }
     *     
     */
    public Packages getPackages() {
        return packages;
    }

    /**
     * Sets the value of the packages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Packages }
     *     
     */
    public void setPackages(Packages value) {
        this.packages = value;
    }

}
