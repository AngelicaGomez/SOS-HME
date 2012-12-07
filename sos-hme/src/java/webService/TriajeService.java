package webService;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2012-12-07T15:19:54.921Z
 * Generated source version: 2.6.2
 * 
 */
@WebServiceClient(name = "TriajeService", 
                  wsdlLocation = "docs/triaje.wsdl",
                  targetNamespace = "http://webService/") 
public class TriajeService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webService/", "TriajeService");
    public final static QName TriajeServicePort = new QName("http://webService/", "TriajeServicePort");
    static {
        URL url = TriajeService.class.getResource("docs/triaje.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(TriajeService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "docs/triaje.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public TriajeService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TriajeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TriajeService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TriajeService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TriajeService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TriajeService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns TriajeServicePortType
     */
    @WebEndpoint(name = "TriajeServicePort")
    public TriajeServicePortType getTriajeServicePort() {
        return super.getPort(TriajeServicePort, TriajeServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TriajeServicePortType
     */
    @WebEndpoint(name = "TriajeServicePort")
    public TriajeServicePortType getTriajeServicePort(WebServiceFeature... features) {
        return super.getPort(TriajeServicePort, TriajeServicePortType.class, features);
    }

}
