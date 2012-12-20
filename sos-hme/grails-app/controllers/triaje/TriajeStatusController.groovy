package triaje

class TriajeStatusController {

    def customSecureServiceClientTriaje
    def index = { 

    String uuid = "312f2a79-7b4d-4d0b-ae27-b62badb622cc"
    
    List<String> CasosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
        if(CasosCerrados){
            CasosCerrados.each{
                render "CASO TRAMITADO CORRECTAMENTE: "+it
            }        
            
        }
    }
}