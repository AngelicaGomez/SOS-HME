package cda;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2013-02-01T10:39:05.411-04:30
 * Generated source version: 2.6.2
 * 
 */
@WebServiceClient(name = "CdaService", 
                  wsdlLocation = "docs/cda.wsdl",
                  targetNamespace = "http://cda/") 
public class CdaService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://cda/", "CdaService");
    public final static QName CdaServicePort = new QName("http://cda/", "CdaServicePort");
    static {
        URL url = CdaService.class.getResource("docs/cda.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(CdaService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "docs/cda.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public CdaService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CdaService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CdaService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CdaService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CdaService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CdaService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns CdaServicePortType
     */
    @WebEndpoint(name = "CdaServicePort")
    public CdaServicePortType getCdaServicePort() {
        return super.getPort(CdaServicePort, CdaServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CdaServicePortType
     */
    @WebEndpoint(name = "CdaServicePort")
    public CdaServicePortType getCdaServicePort(WebServiceFeature... features) {
        return super.getPort(CdaServicePort, CdaServicePortType.class, features);
    }

}
