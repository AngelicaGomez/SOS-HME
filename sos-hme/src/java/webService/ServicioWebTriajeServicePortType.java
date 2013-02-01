package webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2013-02-01T10:39:05.987-04:30
 * Generated source version: 2.6.2
 * 
 */
@WebService(targetNamespace = "http://webService/", name = "ServicioWebTriajeServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface ServicioWebTriajeServicePortType {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "ifCaseSent", targetNamespace = "http://webService/", className = "webService.IfCaseSent")
    @WebMethod
    @ResponseWrapper(localName = "ifCaseSentResponse", targetNamespace = "http://webService/", className = "webService.IfCaseSentResponse")
    public boolean ifCaseSent(
        @WebParam(name = "idCasoSOS", targetNamespace = "")
        java.lang.String idCasoSOS,
        @WebParam(name = "uuid", targetNamespace = "")
        java.lang.String uuid
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getIdCasosEnviados", targetNamespace = "http://webService/", className = "webService.GetIdCasosEnviados")
    @WebMethod
    @ResponseWrapper(localName = "getIdCasosEnviadosResponse", targetNamespace = "http://webService/", className = "webService.GetIdCasosEnviadosResponse")
    public java.util.List<java.lang.String> getIdCasosEnviados(
        @WebParam(name = "uuid", targetNamespace = "")
        java.lang.String uuid
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getSeguimientoDelCaso", targetNamespace = "http://webService/", className = "webService.GetSeguimientoDelCaso")
    @WebMethod
    @ResponseWrapper(localName = "getSeguimientoDelCasoResponse", targetNamespace = "http://webService/", className = "webService.GetSeguimientoDelCasoResponse")
    public webService.PojoSeguimientoCaso getSeguimientoDelCaso(
        @WebParam(name = "idCasoSOS", targetNamespace = "")
        java.lang.String idCasoSOS
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getIdCasoCerrado", targetNamespace = "http://webService/", className = "webService.GetIdCasoCerrado")
    @WebMethod
    @ResponseWrapper(localName = "getIdCasoCerradoResponse", targetNamespace = "http://webService/", className = "webService.GetIdCasoCerradoResponse")
    public java.util.List<java.lang.String> getIdCasoCerrado(
        @WebParam(name = "uuid", targetNamespace = "")
        java.lang.String uuid
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "enviarCasoTriaje", targetNamespace = "http://webService/", className = "webService.EnviarCasoTriaje")
    @WebMethod
    @ResponseWrapper(localName = "enviarCasoTriajeResponse", targetNamespace = "http://webService/", className = "webService.EnviarCasoTriajeResponse")
    public boolean enviarCasoTriaje(
        @WebParam(name = "caso", targetNamespace = "")
        webService.PojoCaso caso,
        @WebParam(name = "uuid", targetNamespace = "")
        java.lang.String uuid
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "enviarObservacionTriaje", targetNamespace = "http://webService/", className = "webService.EnviarObservacionTriaje")
    @WebMethod
    @ResponseWrapper(localName = "enviarObservacionTriajeResponse", targetNamespace = "http://webService/", className = "webService.EnviarObservacionTriajeResponse")
    public boolean enviarObservacionTriaje(
        @WebParam(name = "observacion", targetNamespace = "")
        webService.PojoObservacion observacion,
        @WebParam(name = "uuid", targetNamespace = "")
        java.lang.String uuid
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getCasoResuelto", targetNamespace = "http://webService/", className = "webService.GetCasoResuelto")
    @WebMethod
    @ResponseWrapper(localName = "getCasoResueltoResponse", targetNamespace = "http://webService/", className = "webService.GetCasoResueltoResponse")
    public webService.PojoCasoResuelto getCasoResuelto(
        @WebParam(name = "idCasoSOS", targetNamespace = "")
        java.lang.String idCasoSOS
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getEspecialidades", targetNamespace = "http://webService/", className = "webService.GetEspecialidades")
    @WebMethod
    @ResponseWrapper(localName = "getEspecialidadesResponse", targetNamespace = "http://webService/", className = "webService.GetEspecialidadesResponse")
    public java.util.List<java.lang.String> getEspecialidades(
        @WebParam(name = "uuid", targetNamespace = "")
        java.lang.String uuid
    );
}
