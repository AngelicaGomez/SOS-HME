package triaje


class GetCasoCerradoJob {
    static triggers = {
      //Se ejecuta cada 1 minuto, el primero empieza en el segundo 2
      simple name:'getCasoCerrado', startDelay:2000, repeatInterval: 60000//cada 1 minuto
    }

    def customSecureServiceClientTriaje
    
    def execute() {
        String uuid = "312f2a79-7b4d-4d0b-ae27-b62badb622cc"

//        List<String> CasosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
//         
//            if(CasosCerrados){
//                CasosCerrados.each{
//                    println "CASO TRAMITADO CORRECTAMENTE: "+it
//                }        
//            }
    }
}
