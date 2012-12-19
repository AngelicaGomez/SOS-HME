package triaje


class GetIdCasosCerradosJob {
    static triggers = {
      //Se ejecuta cada 1 minuto, el primero empieza en el segundo 2
      simple name:'getIdCasosCerrados', startDelay:2000, repeatInterval: 60000//cada 6 horas
    }

//    def customSecureServiceClientTriaje
    
    def execute() {
//        String uuid = "312f2a79-7b4d-4d0b-ae27-b62badb622cc"
//        println "paso 1"
//        def idCasosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
//        prntln "paso 2"
//        idCasosCerrados.each{
//            println "CASO CERRADO: "+it
//        }
//        println "paso 3"
    }
}
