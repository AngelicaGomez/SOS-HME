package triaje

import webService.PojoEspecialidad
import webService.PojoPaciente
import webService.PojoArchivo
import webService.PojoCaso

import hce.core.composition.*
import hce.HceService
import templates.TemplateManager
import archetype_repository.ArchetypeManager
//import demographic.party


class TriajeController {
    
    def hceService

    def customSecureServiceClientTriaje
    static String uuid = "312f2a79-7b4d-4d0b-ae27-b62badb622cc"
    
    def index = {      
    }
    
        private Map getDomainTemplates()
    {
        //def routes = grailsApplication.config.domain.split('/') // [hce, trauma]
        //def domainTemplates = grailsApplication.config.templates
        //routes.each{
        //    domainTemplates = domainTemplates[it]
        //}
        
        // =============================================================
        // Nuevo: para devolver los templates del dominio seleccionado
        def domain = session.traumaContext.domainPath
        def domainTemplates = grailsApplication.config.templates2."$domain"
        
        // =============================================================
        
        return domainTemplates
    }
    
    def mostrarEspecialidades = {
       /*  //Con wsdl 18
        boolean answer2 = customSecureServiceClientTriaje.getEspecialidades(uuid)
        if (answer2==true){
            println "SI hay especialicades"
        }else{
            println "NO hay especialicades" 
        }
        */
       
        def composition = Composition.get(session.traumaContext?.episodioId)
        
        def patient = hceService.getPatientFromComposition( composition )
        
//        println "JJJJJJJJJJJJJJJJJJJJJ: "+params.id
//        println "PPPPPPPPPPPPPPPPPPPPP: "+patient.id
        def archetypeIdP
        def templateIdP
        
       
                    int i=0;
                    while (i< composition.content.size())
                    {
                        println "ContenItem: "+composition.content.get(2)
//                        archetypeDetalles = composition.content.get(2).archetypeDetails
                        println "Detalles: "+composition.content.get(2).archetypeDetails
                        println "Nombre: "+composition.content.get(2).name
                        println "Nodo: "+composition.content.get(2).archetypeNodeId
                        println "archetypeId: "+composition.content.get(2).archetypeDetails.archetypeId
                        archetypeIdP = composition.content.get(2).archetypeDetails.archetypeId
                        println "templateId: "+composition.content.get(2).archetypeDetails.templateId
                        templateIdP = composition.content.get(2).archetypeDetails.templateId
                        println "rmVersion: "+composition.content.get(2).archetypeDetails.rmVersion
                        i++;
                    }
  
    
//        def archetypeInstance = ArchetypeManager.getInstance().getArchetype( archetypeIdP )
//        println " archetypeInstance: "+archetypeInstance
//        def templateInstance = TemplateManager.getInstance().getTemplate( templateIdP )        
//        println " templateInstance: "+templateInstance        
    
        //Con wsdl 19
        List<String> especialidadList = new ArrayList<String>();
        
        especialidadList = customSecureServiceClientTriaje.getEspecialidades(uuid)
        
        especialidadList.each{
            println "especialidad nombre: "+it
        }
            
        render(view:"showEnvio2",model:[message:"Especilidades obtenidas con exito", id:params.id, esp:especialidadList, patient:patient, comp:composition/*, archetype:archetypeInstance , template:templateInstance, idPaciente: patient.id, persona:persona, compositions: rangoCompos*/])        
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
