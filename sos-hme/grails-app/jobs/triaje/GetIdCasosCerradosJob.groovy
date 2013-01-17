package triaje

import org.codehaus.groovy.grails.commons.*

import webService.PojoMedico
import webService.PojoCasoResuelto

class GetIdCasosCerradosJob {
    static triggers = {
      //Se ejecuta cada 1 minuto, el primero empieza en el segundo 2
      simple name:'getIdCasosCerrados', startDelay:2000, repeatInterval: 60000//cada 1 minuto
    }

//    def triajeService
    def customSecureServiceClientTriaje
    public PojoCasoResuelto thisCasoResuelto
    public PojoMedico thisResponsable
    
    def execute() {
//        String uuid = "fcf22a15-6871-4469-801c-3eeecce05839"
        String uuid = ConfigurationHolder.config.centroSOS.id

        List<String> casosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
         
        if(casosCerrados){
              casosCerrados.each{
                  
                    println "CASO TRAMITADO CORRECTAMENTE: "+it
                    
                    this.thisCasoResuelto = customSecureServiceClientTriaje.getCasoResuelto(it)
                   
                    this.thisResponsable = thisCasoResuelto.responsable

                    println "DETALLE DEL CASO: "
                    println "CASO: "+thisCasoResuelto.idCasoSOS
                    println "MEDICO RESPONSABLE: "+thisResponsable.nombre+" "+thisResponsable.apellido
//                    println "SOLUCION AL CASO: "+thisCasoResuelto.opinion
                    println "FECHA DE SOLUCION: "+thisCasoResuelto.fechaSolucion
//
                } 
       }
            
    }
}