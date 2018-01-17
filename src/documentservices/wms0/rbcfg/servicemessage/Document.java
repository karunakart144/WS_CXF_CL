
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
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}MetaDataFields" minOccurs="0"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}Content" minOccurs="0"/>
 *         &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}URL" minOccurs="0"/>
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
    "metaDataFields",
    "content",
    "url"
})
@XmlRootElement(name = "Document")
public class Document {

    @XmlElement(name = "MetaDataFields")
    protected MetaDataFields metaDataFields;
    @XmlElement(name = "Content")
    protected Content content;
    @XmlElement(name = "URL")
    protected String url;

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
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

}
