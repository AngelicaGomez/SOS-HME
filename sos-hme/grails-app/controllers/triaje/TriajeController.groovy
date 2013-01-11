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
    static String uuid = "c99338f6-1221-4bc1-a4ea-243eff0b4167"
    
    def index = {      
    }
    
    def viewPreEnvioCaso ={
        
    }
    
    def previewEnviarCaso = {
        def rmNode
        def descripcionCaso = ""
        def pausa =". "
        def episodioId = ""
        def enfermedadActual = false
        
        Composition comp = Composition.get(session.traumaContext.episodioId)        
        def patient = hceService.getPatientFromComposition( comp )
        def templateId = "OBSERVATION-enfermedad_actual"

        episodioId = session.traumaContext.episodioId.toString()
        
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

                     descripcionCaso = descripcionCaso + element[k][j].name.value+": "+element[k][j].value.value + pausa + "\n"
                 
                    j++
                   }
                k++
                }      
        }      
        else{
            if(!descripcionCaso){
//                println "NECESITA LLENAR LOS DATOS DE ENFERMEDAD ACTUAL"
                flash.message = "Pureba"
                redirect( controller: 'records', action: 'show', id: session.traumaContext?.episodioId)
                return
            }   
        }
  
        List<String> especialidadList = new ArrayList<String>();
        
        especialidadList = customSecureServiceClientTriaje.getEspecialidades(uuid)
        
        render(view:"viewPreEnvioCaso",model:[enfermedadActual:enfermedadActual, episodioId:episodioId, id:params.id, esp:especialidadList, patient:patient, descripcionCaso:descripcionCaso])        
     }
    
    def enviarCaso = {        
        String nacionalidad = ""
        String fechaNacimiento = ""
        String nombrePaciente = ""
        String apellidoPaciente = ""
        
        List<String> strinFechaNacimiento = new ArrayList<String>();

         nombrePaciente = params.primerNombre+" "+params.segundoNombre
         apellidoPaciente = params.primerApellido+" "+params.segundoApellido
         
         if(params.nacionalidad=="Venezuela"){
             if(params.sexo=="Masculino"){
                 nacionalidad="Venezonalo"
             }else{
                 nacionalidad="Venezonala"
             }
         }else{
             if(params.sexo=="Masculino"){
                 nacionalidad="Extranjero"
             }else{
                 nacionalidad="Extranjera"
             }             
         }
         
        params.fechaNacimiento.split("\\ ").each{
            strinFechaNacimiento.add(it)
        } 
        
         fechaNacimiento = strinFechaNacimiento.first()
         
       PojoEspecialidad especialidad1 = new PojoEspecialidad()
       especialidad1.setNombre(params.especialidad)
                        
       List<PojoEspecialidad> especialidades = new ArrayList<PojoEspecialidad>();
       especialidades.add(especialidad1)        
            
       PojoPaciente paciente = new PojoPaciente()
            paciente.setNombre(nombrePaciente)
            paciente.setApellido(apellidoPaciente)
            paciente.setCedula(params.cedula)
            paciente.setSexo(params.sexo)
            paciente.setNacionalidad(nacionalidad)
            paciente.setFechaNacimiento(fechaNacimiento)
//
//        //Se abre el archivo
//        File txt = new File("C:/hola.txt")             
////        render txt.getBytes().toString()
//
//       PojoArchivo archivo = new PojoArchivo()
//            archivo.setNombre("hola.txt")
//            archivo.setDescripcion("prueba de archivo")
//            archivo.setAdjunto(txt.getBytes())        
//            
//       List<PojoArchivo> archivos = new ArrayList<PojoArchivo>();
//       archivos.add(archivo)            
//        
////        byte[] bytes = archivo.getBytes() 
        PojoCaso caso = new PojoCaso()
            caso.setIdCasoSOS(params.episodioId)
            caso.archivos = null
            caso.especialidad = especialidades
            caso.setPaciente(paciente)
            caso.setDescripcion(params.descripcionCaso)
        
        boolean answer = customSecureServiceClientTriaje.enviarCasoTriaje(caso, uuid)
        String message=""
        
        if (answer==true){
            render "ACCESO PERMITIDO"
            message = "Caso enviado con exito"
        }else{
            render "ACCESO DENEGADO"
            message = "El Caso NO ha podido ser enviado con exito"
        }        
                         
        render "id"+params.episodioId
            
        render(view:"showEnvio",model:[message:message, id:params.episodioId])
    }    
}
