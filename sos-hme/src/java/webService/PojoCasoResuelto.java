
package webService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para pojoCasoResuelto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pojoCasoResuelto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCasoSOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responsable" type="{http://webService/}pojoMedico" minOccurs="0"/>
 *         &lt;element name="opinion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="archivos" type="{http://webService/}pojoArchivo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fechaSolucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pojoCasoResuelto", propOrder = {
    "idCasoSOS",
    "responsable",
    "opinion",
    "archivos",
    "fechaSolucion"
})
public class PojoCasoResuelto {

    private String idCasoSOS;
    private PojoMedico responsable;
    private String opinion;
    @XmlElement(nillable = true)
    private List<PojoArchivo> archivos;
    private String fechaSolucion;

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
     * Obtiene el valor de la propiedad responsable.
     * 
     * @return
     *     possible object is
     *     {@link PojoMedico }
     *     
     */
    public PojoMedico getResponsable() {
        return responsable;
    }

    /**
     * Define el valor de la propiedad responsable.
     * 
     * @param value
     *     allowed object is
     *     {@link PojoMedico }
     *     
     */
    public void setResponsable(PojoMedico value) {
        this.responsable = value;
    }

    /**
     * Obtiene el valor de la propiedad opinion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpinion() {
        return opinion;
    }

    /**
     * Define el valor de la propiedad opinion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpinion(String value) {
        this.opinion = value;
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

    /**
     * Obtiene el valor de la propiedad fechaSolucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSolucion() {
        return fechaSolucion;
    }

    /**
     * Define el valor de la propiedad fechaSolucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSolucion(String value) {
        this.fechaSolucion = value;
    }

    /**
     * @param archivos the archivos to set
     */
    public void setArchivos(List<PojoArchivo> archivos) {
        this.archivos = archivos;
    }

}
