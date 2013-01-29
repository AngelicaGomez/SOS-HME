
package webService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para pojoOpinion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pojoOpinion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cuerpoOpinion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaOpinion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicoOpinion" type="{http://webService/}pojoMedico" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pojoOpinion", propOrder = {
    "cuerpoOpinion",
    "fechaOpinion",
    "medicoOpinion"
})
public class PojoOpinion {

    protected String cuerpoOpinion;
    protected String fechaOpinion;
    protected PojoMedico medicoOpinion;

    /**
     * Obtiene el valor de la propiedad cuerpoOpinion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuerpoOpinion() {
        return cuerpoOpinion;
    }

    /**
     * Define el valor de la propiedad cuerpoOpinion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuerpoOpinion(String value) {
        this.cuerpoOpinion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaOpinion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaOpinion() {
        return fechaOpinion;
    }

    /**
     * Define el valor de la propiedad fechaOpinion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaOpinion(String value) {
        this.fechaOpinion = value;
    }

    /**
     * Obtiene el valor de la propiedad medicoOpinion.
     * 
     * @return
     *     possible object is
     *     {@link PojoMedico }
     *     
     */
    public PojoMedico getMedicoOpinion() {
        return medicoOpinion;
    }

    /**
     * Define el valor de la propiedad medicoOpinion.
     * 
     * @param value
     *     allowed object is
     *     {@link PojoMedico }
     *     
     */
    public void setMedicoOpinion(PojoMedico value) {
        this.medicoOpinion = value;
    }

}
