
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
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}TransactionResult"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}IncludeDocumentImage" minOccurs="0"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}Documents" minOccurs="0"/>
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
    "transactionResult",
    "includeDocumentImage",
    "documents"
})
@XmlRootElement(name = "DocumentServiceResponse")
public class DocumentServiceResponse {

    @XmlElement(name = "TransactionGUID", required = true)
    protected String transactionGUID;
    @XmlElement(name = "TransactionResult", required = true)
    protected TransactionResult transactionResult;
    @XmlElement(name = "IncludeDocumentImage")
    protected Boolean includeDocumentImage;
    @XmlElement(name = "Documents")
    protected Documents documents;

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
     * Gets the value of the transactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionResult }
     *     
     */
    public TransactionResult getTransactionResult() {
        return transactionResult;
    }

    /**
     * Sets the value of the transactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionResult }
     *     
     */
    public void setTransactionResult(TransactionResult value) {
        this.transactionResult = value;
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
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link Documents }
     *     
     */
    public Documents getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Documents }
     *     
     */
    public void setDocuments(Documents value) {
        this.documents = value;
    }

}
