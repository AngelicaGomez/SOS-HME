package triaje
import org.codehaus.groovy.grails.commons.*

class GetCasoCerradoJob {
    static triggers = {
      //Se ejecuta cada 1 minuto, el primero empieza en el segundo 2
      simple name:'getCasoCerrado', startDelay:2000, repeatInterval: 60000//cada 1 minuto
    }

    def customSecureServiceClientTriaje
    
    def execute() {
        String uuid = ConfigurationHolder.config.centroSOS.id

//        List<String> casosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
//         
//        if(casosCerrados){
//              casosCerrados.each{
//                  
//                    println "CASO TRAMITADO CORRECTAMENTE: "+it
//
//                    render(view: "viewCasoResuelto", controller: "triaje", model: [casosCerrados: casosCerrados])
//                    
//                
//                } 
//       }
    }
}
