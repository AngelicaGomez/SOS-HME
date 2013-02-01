
package webService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webService package. 
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

    private final static QName _GetIdCasosEnviados_QNAME = new QName("http://webService/", "getIdCasosEnviados");
    private final static QName _GetIdCasosEnviadosResponse_QNAME = new QName("http://webService/", "getIdCasosEnviadosResponse");
    private final static QName _GetSeguimientoDelCaso_QNAME = new QName("http://webService/", "getSeguimientoDelCaso");
    private final static QName _EnviarCasoTriajeResponse_QNAME = new QName("http://webService/", "enviarCasoTriajeResponse");
    private final static QName _EnviarCasoTriaje_QNAME = new QName("http://webService/", "enviarCasoTriaje");
    private final static QName _EnviarObservacionTriaje_QNAME = new QName("http://webService/", "enviarObservacionTriaje");
    private final static QName _EnviarObservacionTriajeResponse_QNAME = new QName("http://webService/", "enviarObservacionTriajeResponse");
    private final static QName _GetIdCasoCerradoResponse_QNAME = new QName("http://webService/", "getIdCasoCerradoResponse");
    private final static QName _IfCaseSent_QNAME = new QName("http://webService/", "ifCaseSent");
    private final static QName _GetEspecialidadesResponse_QNAME = new QName("http://webService/", "getEspecialidadesResponse");
    private final static QName _GetIdCasoCerrado_QNAME = new QName("http://webService/", "getIdCasoCerrado");
    private final static QName _IfCaseSentResponse_QNAME = new QName("http://webService/", "ifCaseSentResponse");
    private final static QName _GetEspecialidades_QNAME = new QName("http://webService/", "getEspecialidades");
    private final static QName _GetCasoResuelto_QNAME = new QName("http://webService/", "getCasoResuelto");
    private final static QName _GetCasoResueltoResponse_QNAME = new QName("http://webService/", "getCasoResueltoResponse");
    private final static QName _GetSeguimientoDelCasoResponse_QNAME = new QName("http://webService/", "getSeguimientoDelCasoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIdCasosEnviados }
     * 
     */
    public GetIdCasosEnviados createGetIdCasosEnviados() {
        return new GetIdCasosEnviados();
    }

    /**
     * Create an instance of {@link GetIdCasosEnviadosResponse }
     * 
     */
    public GetIdCasosEnviadosResponse createGetIdCasosEnviadosResponse() {
        return new GetIdCasosEnviadosResponse();
    }

    /**
     * Create an instance of {@link GetSeguimientoDelCaso }
     * 
     */
    public GetSeguimientoDelCaso createGetSeguimientoDelCaso() {
        return new GetSeguimientoDelCaso();
    }

    /**
     * Create an instance of {@link EnviarObservacionTriaje }
     * 
     */
    public EnviarObservacionTriaje createEnviarObservacionTriaje() {
        return new EnviarObservacionTriaje();
    }

    /**
     * Create an instance of {@link EnviarObservacionTriajeResponse }
     * 
     */
    public EnviarObservacionTriajeResponse createEnviarObservacionTriajeResponse() {
        return new EnviarObservacionTriajeResponse();
    }

    /**
     * Create an instance of {@link EnviarCasoTriajeResponse }
     * 
     */
    public EnviarCasoTriajeResponse createEnviarCasoTriajeResponse() {
        return new EnviarCasoTriajeResponse();
    }

    /**
     * Create an instance of {@link EnviarCasoTriaje }
     * 
     */
    public EnviarCasoTriaje createEnviarCasoTriaje() {
        return new EnviarCasoTriaje();
    }

    /**
     * Create an instance of {@link GetIdCasoCerradoResponse }
     * 
     */
    public GetIdCasoCerradoResponse createGetIdCasoCerradoResponse() {
        return new GetIdCasoCerradoResponse();
    }

    /**
     * Create an instance of {@link IfCaseSent }
     * 
     */
    public IfCaseSent createIfCaseSent() {
        return new IfCaseSent();
    }

    /**
     * Create an instance of {@link IfCaseSentResponse }
     * 
     */
    public IfCaseSentResponse createIfCaseSentResponse() {
        return new IfCaseSentResponse();
    }

    /**
     * Create an instance of {@link GetIdCasoCerrado }
     * 
     */
    public GetIdCasoCerrado createGetIdCasoCerrado() {
        return new GetIdCasoCerrado();
    }

    /**
     * Create an instance of {@link GetEspecialidadesResponse }
     * 
     */
    public GetEspecialidadesResponse createGetEspecialidadesResponse() {
        return new GetEspecialidadesResponse();
    }

    /**
     * Create an instance of {@link GetCasoResuelto }
     * 
     */
    public GetCasoResuelto createGetCasoResuelto() {
        return new GetCasoResuelto();
    }

    /**
     * Create an instance of {@link GetEspecialidades }
     * 
     */
    public GetEspecialidades createGetEspecialidades() {
        return new GetEspecialidades();
    }

    /**
     * Create an instance of {@link GetSeguimientoDelCasoResponse }
     * 
     */
    public GetSeguimientoDelCasoResponse createGetSeguimientoDelCasoResponse() {
        return new GetSeguimientoDelCasoResponse();
    }

    /**
     * Create an instance of {@link GetCasoResueltoResponse }
     * 
     */
    public GetCasoResueltoResponse createGetCasoResueltoResponse() {
        return new GetCasoResueltoResponse();
    }

    /**
     * Create an instance of {@link PojoMedico }
     * 
     */
    public PojoMedico createPojoMedico() {
        return new PojoMedico();
    }

    /**
     * Create an instance of {@link PojoObservacion }
     * 
     */
    public PojoObservacion createPojoObservacion() {
        return new PojoObservacion();
    }

    /**
     * Create an instance of {@link PojoEspecialidad }
     * 
     */
    public PojoEspecialidad createPojoEspecialidad() {
        return new PojoEspecialidad();
    }

    /**
     * Create an instance of {@link PojoCaso }
     * 
     */
    public PojoCaso createPojoCaso() {
        return new PojoCaso();
    }

    /**
     * Create an instance of {@link PojoOpinion }
     * 
     */
    public PojoOpinion createPojoOpinion() {
        return new PojoOpinion();
    }

    /**
     * Create an instance of {@link PojoArchivo }
     * 
     */
    public PojoArchivo createPojoArchivo() {
        return new PojoArchivo();
    }

    /**
     * Create an instance of {@link PojoPaciente }
     * 
     */
    public PojoPaciente createPojoPaciente() {
        return new PojoPaciente();
    }

    /**
     * Create an instance of {@link PojoCasoResuelto }
     * 
     */
    public PojoCasoResuelto createPojoCasoResuelto() {
        return new PojoCasoResuelto();
    }

    /**
     * Create an instance of {@link PojoSeguimientoCaso }
     * 
     */
    public PojoSeguimientoCaso createPojoSeguimientoCaso() {
        return new PojoSeguimientoCaso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdCasosEnviados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getIdCasosEnviados")
    public JAXBElement<GetIdCasosEnviados> createGetIdCasosEnviados(GetIdCasosEnviados value) {
        return new JAXBElement<GetIdCasosEnviados>(_GetIdCasosEnviados_QNAME, GetIdCasosEnviados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdCasosEnviadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getIdCasosEnviadosResponse")
    public JAXBElement<GetIdCasosEnviadosResponse> createGetIdCasosEnviadosResponse(GetIdCasosEnviadosResponse value) {
        return new JAXBElement<GetIdCasosEnviadosResponse>(_GetIdCasosEnviadosResponse_QNAME, GetIdCasosEnviadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSeguimientoDelCaso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getSeguimientoDelCaso")
    public JAXBElement<GetSeguimientoDelCaso> createGetSeguimientoDelCaso(GetSeguimientoDelCaso value) {
        return new JAXBElement<GetSeguimientoDelCaso>(_GetSeguimientoDelCaso_QNAME, GetSeguimientoDelCaso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarCasoTriajeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "enviarCasoTriajeResponse")
    public JAXBElement<EnviarCasoTriajeResponse> createEnviarCasoTriajeResponse(EnviarCasoTriajeResponse value) {
        return new JAXBElement<EnviarCasoTriajeResponse>(_EnviarCasoTriajeResponse_QNAME, EnviarCasoTriajeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarCasoTriaje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "enviarCasoTriaje")
    public JAXBElement<EnviarCasoTriaje> createEnviarCasoTriaje(EnviarCasoTriaje value) {
        return new JAXBElement<EnviarCasoTriaje>(_EnviarCasoTriaje_QNAME, EnviarCasoTriaje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarObservacionTriaje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "enviarObservacionTriaje")
    public JAXBElement<EnviarObservacionTriaje> createEnviarObservacionTriaje(EnviarObservacionTriaje value) {
        return new JAXBElement<EnviarObservacionTriaje>(_EnviarObservacionTriaje_QNAME, EnviarObservacionTriaje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarObservacionTriajeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "enviarObservacionTriajeResponse")
    public JAXBElement<EnviarObservacionTriajeResponse> createEnviarObservacionTriajeResponse(EnviarObservacionTriajeResponse value) {
        return new JAXBElement<EnviarObservacionTriajeResponse>(_EnviarObservacionTriajeResponse_QNAME, EnviarObservacionTriajeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdCasoCerradoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getIdCasoCerradoResponse")
    public JAXBElement<GetIdCasoCerradoResponse> createGetIdCasoCerradoResponse(GetIdCasoCerradoResponse value) {
        return new JAXBElement<GetIdCasoCerradoResponse>(_GetIdCasoCerradoResponse_QNAME, GetIdCasoCerradoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfCaseSent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "ifCaseSent")
    public JAXBElement<IfCaseSent> createIfCaseSent(IfCaseSent value) {
        return new JAXBElement<IfCaseSent>(_IfCaseSent_QNAME, IfCaseSent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEspecialidadesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getEspecialidadesResponse")
    public JAXBElement<GetEspecialidadesResponse> createGetEspecialidadesResponse(GetEspecialidadesResponse value) {
        return new JAXBElement<GetEspecialidadesResponse>(_GetEspecialidadesResponse_QNAME, GetEspecialidadesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdCasoCerrado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getIdCasoCerrado")
    public JAXBElement<GetIdCasoCerrado> createGetIdCasoCerrado(GetIdCasoCerrado value) {
        return new JAXBElement<GetIdCasoCerrado>(_GetIdCasoCerrado_QNAME, GetIdCasoCerrado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfCaseSentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "ifCaseSentResponse")
    public JAXBElement<IfCaseSentResponse> createIfCaseSentResponse(IfCaseSentResponse value) {
        return new JAXBElement<IfCaseSentResponse>(_IfCaseSentResponse_QNAME, IfCaseSentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEspecialidades }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getEspecialidades")
    public JAXBElement<GetEspecialidades> createGetEspecialidades(GetEspecialidades value) {
        return new JAXBElement<GetEspecialidades>(_GetEspecialidades_QNAME, GetEspecialidades.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCasoResuelto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getCasoResuelto")
    public JAXBElement<GetCasoResuelto> createGetCasoResuelto(GetCasoResuelto value) {
        return new JAXBElement<GetCasoResuelto>(_GetCasoResuelto_QNAME, GetCasoResuelto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCasoResueltoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getCasoResueltoResponse")
    public JAXBElement<GetCasoResueltoResponse> createGetCasoResueltoResponse(GetCasoResueltoResponse value) {
        return new JAXBElement<GetCasoResueltoResponse>(_GetCasoResueltoResponse_QNAME, GetCasoResueltoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSeguimientoDelCasoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getSeguimientoDelCasoResponse")
    public JAXBElement<GetSeguimientoDelCasoResponse> createGetSeguimientoDelCasoResponse(GetSeguimientoDelCasoResponse value) {
        return new JAXBElement<GetSeguimientoDelCasoResponse>(_GetSeguimientoDelCasoResponse_QNAME, GetSeguimientoDelCasoResponse.class, null, value);
    }

}
