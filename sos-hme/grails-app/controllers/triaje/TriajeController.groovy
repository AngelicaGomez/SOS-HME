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
import webService.PojoCasoResuelto
import webService.PojoMedico
//import demographic.party
import org.codehaus.groovy.grails.commons.*

class TriajeController {
    
    def hceService

    def customSecureServiceClientTriaje
//    static String uuid = "fcf22a15-6871-4469-801c-3eeecce05839"
    static String uuid = ConfigurationHolder.config.centroSOS.id
    public PojoCasoResuelto thisCasoResuelto
    public PojoMedico thisResponsable
//    static List<PojoCasoResuelto> casosParaMostrar = new List<PojoCasoResuelto>
        
    def index = {      
    }
    
    def viewPreEnvioCaso ={
        
    }
    
    def viewCasoResuelto ={
        List<String> casosParaMostrar = new ArrayList<String>();
        List<String> casosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
                
        if(casosCerrados){
              casosCerrados.each{
                  
                    println "CASO TRAMITADO CORRECTAMENTE: "+it
                    
                    this.thisCasoResuelto = customSecureServiceClientTriaje.getCasoResuelto(it)
                   
                    this.thisResponsable = thisCasoResuelto.responsable

//                    println "DETALLE DEL CASO: "
//                    println "CASO: "+thisCasoResuelto.idCasoSOS
//                    println "MEDICO RESPONSABLE: "+thisResponsable.nombre+" "+thisResponsable.apellido
//                    println "SOLUCION AL CASO: "+thisCasoResuelto.opinion
//                    println "FECHA DE SOLUCION: "+thisCasoResuelto.fechaSolucion
//
                    casosParaMostrar.add(thisCasoResuelto)
                    
                    render(view: "viewCasoResuelto", model: [casoInstanceList: casosCerrados, responsable:thisResponsable, caso:thisCasoResuelto, casoMostrado:casosParaMostrar]) 
                } 
       }
    
//        List<String> casosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
//         
//        if(casosCerrados){
//
//            render(view: "viewCasoResuelto", model: [casoInstanceList: casosCerrados]) 
//       }        
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
                String tipo = "sinEnfermedadActual"
                flash.message = 'default.no.description.message'
                redirect( controller: 'records', action: 'show', id: session.traumaContext?.episodioId, params:[tipo:tipo])
//                redirect(controller:'records', action:'list')
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
         
       List<PojoEspecialidad> especialidades = new ArrayList<PojoEspecialidad>();
       
        if(params.especialidad){
            PojoEspecialidad especialidad1 = new PojoEspecialidad()
            especialidad1.setNombre(params.especialidad)
                        
            especialidades.add(especialidad1)
        }        
        
        if(params.especialidad2){
            PojoEspecialidad especialidad2 = new PojoEspecialidad()
            especialidad2.setNombre(params.especialidad2)
                        
            especialidades.add(especialidad2)
        }                   

            
       PojoPaciente paciente = new PojoPaciente()
            paciente.setNombre(nombrePaciente)
            paciente.setApellido(apellidoPaciente)
            paciente.setCedula(params.cedula)
            paciente.setSexo(params.sexo)
            paciente.setNacionalidad(nacionalidad)
            paciente.setFechaNacimiento(fechaNacimiento)

        // //Se abre el archivo
        // File txt = new File("C:/hola.txt")
        //// render txt.getBytes().toString()
        //
        // PojoArchivo archivo = new PojoArchivo()
        // archivo.setNombre("hola.txt")
        // archivo.setDescripcion("prueba de archivo")
        // archivo.setAdjunto(txt.getBytes())
        //
        // List<PojoArchivo> archivos = new ArrayList<PojoArchivo>();
        // archivos.add(archivo)
        //
        //// byte[] bytes = archivo.getBytes()
        
        PojoCaso caso = new PojoCaso()
            caso.setIdCasoSOS(params.episodioId)
            caso.archivos = null
            if(especialidades){
                caso.especialidad = especialidades
            }else{
                caso.especialidad = null
            }
            
            caso.setPaciente(paciente)
            caso.setDescripcion(params.descripcionCaso)
        
        boolean answer = customSecureServiceClientTriaje.enviarCasoTriaje(caso, uuid)
        String message=""
        
        if (answer==true){
//            render "ACCESO PERMITIDO"
//            message = "Caso enviado con exito"
            
            flash.message = "default.send.caso.message"
            redirect( controller: 'records', action: 'show', id: session.traumaContext?.episodioId)
            return  
        
        }else{
//            render "ACCESO DENEGADO"
//            message = "El Caso NO ha podido ser enviado con exito"
            flash.message = "default.no.send.caso.message"
            redirect( controller: 'records', action: 'show', id: session.traumaContext?.episodioId)
            return  
        }
                         
//        render "id"+params.episodioId
//            
//        render(view:"showEnvio",model:[message:message, id:params.episodioId])
        
        //no se ve mensaje de exitoxq se redirecciona sin mostrar mensaje!!


        
   }    
}