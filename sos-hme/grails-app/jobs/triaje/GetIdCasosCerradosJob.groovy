package triaje

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
        String uuid = "312f2a79-7b4d-4d0b-ae27-b62badb622cc"

        List<String> casosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
         
        if(casosCerrados){
              casosCerrados.each{
                  
                    println "CASO TRAMITADO CORRECTAMENTE: "+it
                    this.thisCasoResuelto = customSecureServiceClientTriaje.getCasoResuelto(it)
                    println "paso 1"

                    this.thisResponsable = thisCasoResuelto.responsable

                    println "DETALLE DEL CASO: "
                    println "CASO: "+thisCasoResuelto.idCasoSOS
                    println "MEDICO RESPONSABLE: "+thisResponsable.nombre+" "+thisResponsable.apellido
                    println "SOLUCION AL CASO: "+thisCasoResuelto.opinion
                    println "FECHA DE SOLUCION: "+thisCasoResuelto.fechaSolucion

                } 
       }
            
    }
}