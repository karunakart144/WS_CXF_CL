
package documentservices.wms0.rbcfg.servicemessage;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
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
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}objectMimeType"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}objectContent"/>
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
    "objectMimeType",
    "objectContent"
})
@XmlRootElement(name = "Content")
public class Content {

    @XmlElement(required = true)
    protected String objectMimeType;
    @XmlElement(required = true)
    @XmlMimeType("*/*")
    protected DataHandler objectContent;

    /**
     * Gets the value of the objectMimeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectMimeType() {
        return objectMimeType;
    }

    /**
     * Sets the value of the objectMimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectMimeType(String value) {
        this.objectMimeType = value;
    }

    /**
     * Gets the value of the objectContent property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getObjectContent() {
        return objectContent;
    }

    /**
     * Sets the value of the objectContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setObjectContent(DataHandler value) {
        this.objectContent = value;
    }

}
