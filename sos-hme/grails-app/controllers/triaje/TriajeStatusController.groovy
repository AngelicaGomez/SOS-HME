package triaje

import org.codehaus.groovy.grails.commons.*

class TriajeStatusController {

    def customSecureServiceClientTriaje
    def index = { 

    String uuid = ConfigurationHolder.config.centroSOS.id
    
    List<String> CasosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
        if(CasosCerrados){
            CasosCerrados.each{
                render "CASO TRAMITADO CORRECTAMENTE: "+it
            }        
            
        }
    }
}