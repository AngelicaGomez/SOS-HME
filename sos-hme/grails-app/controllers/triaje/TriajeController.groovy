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
    static String uuid = ConfigurationHolder.config.centroSOS.id
    public PojoCasoResuelto thisCasoResuelto
    public PojoMedico thisResponsable
        
    def index = {      
    }
    
    def viewPreEnvioCaso ={
        
    }
    
    //METODO PARA MOSTRAR LOS CASOS CERRADOS
    def viewCasoResuelto ={
        List<String> casosParaMostrar = new ArrayList<String>();
        List<String> casosCerrados = new ArrayList<String>();
        
        casosCerrados = customSecureServiceClientTriaje.getIdCasoCerrado(uuid)
                
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
     }
    
    //METODO PARA GENERAR VISTA DEL PREVIEW DEL CASO A ENVIAR
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
        
        //SERVICIO PROPIO DE SOS-HME PARA OBTENER LA COMPOSICION DEL PACIENTE
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
                String tipo = "sinEnfermedadActual"
                redirect( controller: 'records', action: 'show', id: session.traumaContext?.episodioId, params:[tipo:tipo])
                return
            }   
        }
  
        List<String> especialidadList = new ArrayList<String>();
        
        //SERVICIO PARA MOSTRAR EN SOS-HME LAS ESPECIALIDADES SEGUN ESPECIALISTAS DISPONIBLES EN SOS-TRIAJE
        especialidadList = customSecureServiceClientTriaje.getEspecialidades(uuid)
        
        render(view:"viewPreEnvioCaso",model:[enfermedadActual:enfermedadActual, episodioId:episodioId, id:params.id, esp:especialidadList, patient:patient, descripcionCaso:descripcionCaso])        
     }
    
    //METODO PARA OBTENER LOS DATOS DE LA VISTA PREVIEW DEL CASO A ENVIAR, CREAR EL POJOCASO Y USAR EL SERVICIO PARA ENVIAR EL CASO A SOS-TRIAJE
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
        
        //SERVICIO PARA VERIFICAR SI EL CASO QUE SE INTENTA ENVIAR A SOS-TRIAJE YA HA SIDO ENVIADO        
        boolean enviado = customSecureServiceClientTriaje.ifCaseSent(params.episodioId, uuid)
        
        if (enviado){
                String tipo = "casoEnviadoAnteriormente"
                redirect( controller: 'records', action: 'show', id: session.traumaContext?.episodioId, params:[tipo:tipo])
                return            
        }else{
                //SERVICIO PARA ENVIAR EL CASO A SOS-TRIAJE DESDE SOS-HME Y OPERAR SOS-TRIAJE        
                boolean answer = customSecureServiceClientTriaje.enviarCasoTriaje(caso, uuid)

                if (answer==true){
                    String tipo = "casoSinPoderEnviar"
                    redirect( controller: 'records', action: 'show', id: session.traumaContext?.episodioId, params:[tipo:tipo])
                    return          
                }else{
                    String tipo = "casoEnviadoConExito"
                    redirect( controller: 'records', action: 'show', id: session.traumaContext?.episodioId, params:[tipo:tipo])
                    return  
                }
        }
   }    
}