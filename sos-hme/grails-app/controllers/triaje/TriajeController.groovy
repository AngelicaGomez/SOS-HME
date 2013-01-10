package triaje

import webService.PojoEspecialidad
import webService.PojoPaciente
import webService.PojoArchivo
import webService.PojoCaso

import hce.core.composition.*
import hce.HceService
import templates.TemplateManager
import archetype_repository.ArchetypeManager
import hce.core.common.archetyped.Locatable
//import demographic.party


class TriajeController {
    
    def hceService

    def customSecureServiceClientTriaje
    static String uuid = "312f2a79-7b4d-4d0b-ae27-b62badb622cc"
    
    def index = {      
    }
    
    def viewPreEnvioCaso ={
        
    }
    
    def mostrarEspecialidades = {
        def rmNode
        def descripcionCaso = ""
        def pausa =". "
        def episodioId = ""
        def enfermedadActual = false
        
        Composition comp = Composition.get(session.traumaContext.episodioId)        
        def patient = hceService.getPatientFromComposition( comp )
        def templateId = "OBSERVATION-enfermedad_actual"
//        println "COMPOSICION DEL PACIENTE: "+comp

        episodioId = session.traumaContext.episodioId.toString()
//        println "Episodio id: "+episodioId
        
        def item = hceService.getCompositionContentItemForTemplate( comp, templateId )
        
        if (item != null){
            rmNode =  Locatable.findByName(item.name) //enlace al nodo de la composition en el modelo de referencia   
            def rmNodeData =  rmNode.data     
            def rmNodeDataEvents = rmNodeData.events
            
            def k=0 // variable de ciclo, usada en caso de que la composition tenga varios 
            def j=0
            if (k==(k+1)){
               j=0
            }
            
            def element = rmNodeDataEvents[0].data.items.items[0].items
          
                while(element[k]!=null){   
                   enfermedadActual = true
                   while(element[k][j]!=null){
//                       println "elemento[k][j]: "+element[k][j]
                     descripcionCaso = descripcionCaso + element[k][j].name.value+": "+element[k][j].value.value + pausa
          
                    j++
                   }
                k++
                }      
        }

        List<String> especialidadList = new ArrayList<String>();
        
        especialidadList = customSecureServiceClientTriaje.getEspecialidades(uuid)
        
//        especialidadList.each{
//            println "especialidad nombre: "+it
//        }
            
//        render(view:"showEnvio2",model:[enfermedadActual:enfermedadActual, episodioId:episodioId, id:params.id, esp:especialidadList, patient:patient, descripcionCaso:descripcionCaso])        
        render(view:"viewPreEnvioCaso",model:[enfermedadActual:enfermedadActual, episodioId:episodioId, id:params.id, esp:especialidadList, patient:patient, descripcionCaso:descripcionCaso])        
     }
    
    def enviarCaso = {
       PojoEspecialidad especialidad1 = new PojoEspecialidad()
       especialidad1.setNombre("Dermatologia")
                        
       List<PojoEspecialidad> especialidades = new ArrayList<PojoEspecialidad>();
       especialidades.add(especialidad1)        
            
       PojoPaciente paciente = new PojoPaciente()
            paciente.setNombre("Carmen")
            paciente.setApellido("Guzman")
            paciente.setCedula("19867443")
            paciente.setSexo("Femenino")
            paciente.setNacionalidad("Venezolana")
            paciente.setFechaNacimiento("1987-06-01")

        //Se abre el archivo
        File txt = new File("C:/hola.txt")             
//        render txt.getBytes().toString()

       PojoArchivo archivo = new PojoArchivo()
            archivo.setNombre("hola.txt")
            archivo.setDescripcion("prueba de archivo")
            archivo.setAdjunto(txt.getBytes())        
            
       List<PojoArchivo> archivos = new ArrayList<PojoArchivo>();
       archivos.add(archivo)            
        
//        byte[] bytes = archivo.getBytes() 
        
        PojoCaso caso = new PojoCaso()
            caso.setIdCasoSOS("10a")
            caso.archivos = archivos
            caso.especialidad = especialidades
            caso.setPaciente(paciente)
            caso.setDescripcion("Desc. Caso de prueba enviado desde SOS-HME")
        
        boolean answer = customSecureServiceClientTriaje.enviarCasoTriaje(caso, uuid)
        
        if (answer==true){
            render "ACCESO PERMITIDO"
        }else{
            render "ACCESO DENEGADO"
        }        
        
        
        render "id"+params.id
            
        render(view:"showEnvio",model:[message:"Caso enviado con exito", id:params.id])
    }    
}
