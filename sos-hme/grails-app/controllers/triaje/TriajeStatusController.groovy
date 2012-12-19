package triaje

class TriajeStatusController {

    def customSecureServiceClientTriaje
    def index = { 
        
    
//    List idCasosCerrados = []
    String uuid = "312f2a79-7b4d-4d0b-ae27-b62badb622cc"
    
//    def idCasosCerrados
    def idCasosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
//    boolean answer = customSecureServiceClientTriaje.enviarCasoTriaje(caso, uuid)

//        idCasosCerrados.each{
//            println "CASO CERRADO: "+it
//        }        

//        while (i< thisEspecialidades.size())
//    {
//        def especialidad = Especialidad.findByNombre(thisEspecialidades.get(i).nombre)
//        casoNuevo.addToEspecialidades(especialidad)
//        i++;
//    }
        
    
    }
}