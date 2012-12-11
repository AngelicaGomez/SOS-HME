package imp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2012-12-11T10:12:55.744-04:30
 * Generated source version: 2.6.2
 * 
 */
@WebService(targetNamespace = "http://imp/", name = "ImpServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface ImpServicePortType {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "agregarImagenPaciente", targetNamespace = "http://imp/", className = "imp.AgregarImagenPaciente")
    @WebMethod
    @ResponseWrapper(localName = "agregarImagenPacienteResponse", targetNamespace = "http://imp/", className = "imp.AgregarImagenPacienteResponse")
    public boolean agregarImagenPaciente(
        @WebParam(name = "imagen", targetNamespace = "")
        byte[] imagen,
        @WebParam(name = "nombre", targetNamespace = "")
        java.lang.String nombre,
        @WebParam(name = "idPacienteOrg", targetNamespace = "")
        java.lang.String idPacienteOrg,
        @WebParam(name = "idOrganizacion", targetNamespace = "")
        java.lang.String idOrganizacion
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "eliminarRelacionPaciente", targetNamespace = "http://imp/", className = "imp.EliminarRelacionPaciente")
    @WebMethod
    @ResponseWrapper(localName = "eliminarRelacionPacienteResponse", targetNamespace = "http://imp/", className = "imp.EliminarRelacionPacienteResponse")
    public boolean eliminarRelacionPaciente(
        @WebParam(name = "idPacienteOrg", targetNamespace = "")
        java.lang.String idPacienteOrg,
        @WebParam(name = "idOrganizacion", targetNamespace = "")
        java.lang.String idOrganizacion
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "agregarPaciente", targetNamespace = "http://imp/", className = "imp.AgregarPaciente")
    @WebMethod
    @ResponseWrapper(localName = "agregarPacienteResponse", targetNamespace = "http://imp/", className = "imp.AgregarPacienteResponse")
    public boolean agregarPaciente(
        @WebParam(name = "paciente", targetNamespace = "")
        imp.PacienteArr paciente,
        @WebParam(name = "idOrganizacion", targetNamespace = "")
        java.lang.String idOrganizacion
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "existePaciente", targetNamespace = "http://imp/", className = "imp.ExistePaciente")
    @WebMethod
    @ResponseWrapper(localName = "existePacienteResponse", targetNamespace = "http://imp/", className = "imp.ExistePacienteResponse")
    public boolean existePaciente(
        @WebParam(name = "idPacienteOrg", targetNamespace = "")
        java.lang.String idPacienteOrg,
        @WebParam(name = "idOrganizacion", targetNamespace = "")
        java.lang.String idOrganizacion
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "eliminarPaciente", targetNamespace = "http://imp/", className = "imp.EliminarPaciente")
    @WebMethod
    @ResponseWrapper(localName = "eliminarPacienteResponse", targetNamespace = "http://imp/", className = "imp.EliminarPacienteResponse")
    public boolean eliminarPaciente(
        @WebParam(name = "idPacienteOrg", targetNamespace = "")
        java.lang.String idPacienteOrg,
        @WebParam(name = "idOrganizacion", targetNamespace = "")
        java.lang.String idOrganizacion
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "agregarRelacionPaciente", targetNamespace = "http://imp/", className = "imp.AgregarRelacionPaciente")
    @WebMethod
    @ResponseWrapper(localName = "agregarRelacionPacienteResponse", targetNamespace = "http://imp/", className = "imp.AgregarRelacionPacienteResponse")
    public boolean agregarRelacionPaciente(
        @WebParam(name = "idCentroImp", targetNamespace = "")
        java.lang.Long idCentroImp,
        @WebParam(name = "idPacienteImp", targetNamespace = "")
        java.lang.String idPacienteImp,
        @WebParam(name = "idPacienteOrg", targetNamespace = "")
        java.lang.String idPacienteOrg,
        @WebParam(name = "idOrganizacion", targetNamespace = "")
        java.lang.String idOrganizacion
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "existeRelacionPaciente", targetNamespace = "http://imp/", className = "imp.ExisteRelacionPaciente")
    @WebMethod
    @ResponseWrapper(localName = "existeRelacionPacienteResponse", targetNamespace = "http://imp/", className = "imp.ExisteRelacionPacienteResponse")
    public boolean existeRelacionPaciente(
        @WebParam(name = "idPacienteOrg", targetNamespace = "")
        java.lang.String idPacienteOrg,
        @WebParam(name = "idOrganizacion", targetNamespace = "")
        java.lang.String idOrganizacion
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "buscarCandidatos", targetNamespace = "http://imp/", className = "imp.BuscarCandidatos")
    @WebMethod
    @ResponseWrapper(localName = "buscarCandidatosResponse", targetNamespace = "http://imp/", className = "imp.BuscarCandidatosResponse")
    public imp.ConjuntoPaciente buscarCandidatos(
        @WebParam(name = "paciente", targetNamespace = "")
        imp.PacienteArr paciente,
        @WebParam(name = "offset", targetNamespace = "")
        int offset,
        @WebParam(name = "idOrganizacion", targetNamespace = "")
        java.lang.String idOrganizacion
    );
}
