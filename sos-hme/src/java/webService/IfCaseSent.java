
package webService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ifCaseSent complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ifCaseSent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCasoSOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ifCaseSent", propOrder = {
    "idCasoSOS",
    "uuid"
})
public class IfCaseSent {

    protected String idCasoSOS;
    protected String uuid;

    /**
     * Obtiene el valor de la propiedad idCasoSOS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCasoSOS() {
        return idCasoSOS;
    }

    /**
     * Define el valor de la propiedad idCasoSOS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCasoSOS(String value) {
        this.idCasoSOS = value;
    }

    /**
     * Obtiene el valor de la propiedad uuid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Define el valor de la propiedad uuid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

}
