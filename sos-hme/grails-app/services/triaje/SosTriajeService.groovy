package triaje

import pojos.PojoCasoResuelto
class SosTriajeService {

    static transactional = true

     static expose=['cxf']
     
    String servicioPruebaSosHME() {       
        
        return "Este es un servicio de prueba SOS-HME"
        
    }
    
//   PojoCasoResuelto enviarCasoSosHme(PojoCasoResuelto caso){
//        
//        return caso
//    }

   boolean enviarCasoSosHme(PojoCasoResuelto caso){
        boolean flag = false
        
        if(caso){
            flag = true
        }
        
        return flag
    }    
}
