
package webService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para pojoSeguimientoCaso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pojoSeguimientoCaso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCasoSOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opiniones" type="{http://webService/}pojoOpinion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="archivos" type="{http://webService/}pojoArchivo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pojoSeguimientoCaso", propOrder = {
    "idCasoSOS",
    "opiniones",
    "archivos"
})
public class PojoSeguimientoCaso {

    protected String idCasoSOS;
    @XmlElement(nillable = true)
    protected List<PojoOpinion> opiniones;
    @XmlElement(nillable = true)
    protected List<PojoArchivo> archivos;

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
     * Gets the value of the opiniones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opiniones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpiniones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PojoOpinion }
     * 
     * 
     */
    public List<PojoOpinion> getOpiniones() {
        if (opiniones == null) {
            opiniones = new ArrayList<PojoOpinion>();
        }
        return this.opiniones;
    }

    /**
     * Gets the value of the archivos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the archivos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArchivos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PojoArchivo }
     * 
     * 
     */
    public List<PojoArchivo> getArchivos() {
        if (archivos == null) {
            archivos = new ArrayList<PojoArchivo>();
        }
        return this.archivos;
    }

}
