package triaje

import org.codehaus.groovy.grails.commons.*

import webService.PojoMedico
import webService.PojoCasoResuelto

class GetIdCasosCerradosJob {
    static triggers = {
      //Se ejecuta cada 1 minuto, el primero empieza en el segundo 2
      simple name:'getIdCasosCerrados', startDelay:2000, repeatInterval: 60000//cada 1 minuto
    }

    def customSecureServiceClientTriaje
    public PojoCasoResuelto thisCasoResuelto
    public PojoMedico thisResponsable
    
    def execute() {
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
                    println "FECHA DE SOLUCION: "+thisCasoResuelto.fechaSolucion
                } 
       }
            
    }
}