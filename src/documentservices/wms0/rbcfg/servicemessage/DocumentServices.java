
package documentservices.wms0.rbcfg.servicemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}UserAuthRequest" minOccurs="0"/>
 *           &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}DocumentServiceRequest" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}UserAuthResponse" minOccurs="0"/>
 *           &lt;element ref="{http://RBCFG.WMS0.DocumentServices/ServiceMessage}DocumentServiceResponse" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userAuthRequest",
    "documentServiceRequest",
    "userAuthResponse",
    "documentServiceResponse"
})
@XmlRootElement(name = "DocumentServices")
public class DocumentServices {

    @XmlElement(name = "UserAuthRequest")
    protected UserAuthRequest userAuthRequest;
    @XmlElement(name = "DocumentServiceRequest")
    protected DocumentServiceRequest documentServiceRequest;
    @XmlElement(name = "UserAuthResponse")
    protected UserAuthResponse userAuthResponse;
    @XmlElement(name = "DocumentServiceResponse")
    protected DocumentServiceResponse documentServiceResponse;
    @XmlAttribute(name = "Version")
    protected String version;

    /**
     * Gets the value of the userAuthRequest property.
     * 
     * @return
     *     possible object is
     *     {@link UserAuthRequest }
     *     
     */
    public UserAuthRequest getUserAuthRequest() {
        return userAuthRequest;
    }

    /**
     * Sets the value of the userAuthRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAuthRequest }
     *     
     */
    public void setUserAuthRequest(UserAuthRequest value) {
        this.userAuthRequest = value;
    }

    /**
     * Gets the value of the documentServiceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentServiceRequest }
     *     
     */
    public DocumentServiceRequest getDocumentServiceRequest() {
        return documentServiceRequest;
    }

    /**
     * Sets the value of the documentServiceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentServiceRequest }
     *     
     */
    public void setDocumentServiceRequest(DocumentServiceRequest value) {
        this.documentServiceRequest = value;
    }

    /**
     * Gets the value of the userAuthResponse property.
     * 
     * @return
     *     possible object is
     *     {@link UserAuthResponse }
     *     
     */
    public UserAuthResponse getUserAuthResponse() {
        return userAuthResponse;
    }

    /**
     * Sets the value of the userAuthResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAuthResponse }
     *     
     */
    public void setUserAuthResponse(UserAuthResponse value) {
        this.userAuthResponse = value;
    }

    /**
     * Gets the value of the documentServiceResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentServiceResponse }
     *     
     */
    public DocumentServiceResponse getDocumentServiceResponse() {
        return documentServiceResponse;
    }

    /**
     * Sets the value of the documentServiceResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentServiceResponse }
     *     
     */
    public void setDocumentServiceResponse(DocumentServiceResponse value) {
        this.documentServiceResponse = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
