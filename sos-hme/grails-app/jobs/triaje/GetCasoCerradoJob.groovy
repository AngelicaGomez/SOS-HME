package triaje
import org.codehaus.groovy.grails.commons.*

class GetCasoCerradoJob {
    static triggers = {
      //Se ejecuta cada 1 minuto, el primero empieza en el segundo 2
      simple name:'getCasoCerrado', startDelay:2000, repeatInterval: 60000//cada 1 minuto
    }

    def customSecureServiceClientTriaje
    
    def execute() {
//        String uuid = "fcf22a15-6871-4469-801c-3eeecce05839"
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
