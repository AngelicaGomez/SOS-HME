package triaje

class TriajeService {

    static transactional = true
    
    //Mapa de los archivos y el caso al que pertenecen
    static mapArchivoPorCasos= [:]
    
    List<String> mostrarCaso (List<String> newLista){
        //Lista que acumulara por centros los casos que han sido impresos
        List<String> casosImpresos = new ArrayList<String>() 
        //Lista que contendra los casos que deberan ser impresos
        List<String> casosAImprimir = new ArrayList<String>()
        
            int i=0;
            while (i< newLista.size())
            {
                int j=0;
                while (j< casosImpresos.size()){
                    if((casosImpresos.get(j))!=(newLista.get(i))){
                        casosAImprimir.add(newLista.get(i))    
                    }
                j++;
                }
            i++;
            }
            
        return casosAImprimir
    }
    
    def llenarMapa(String originalFilename, String episodioId){
         mapArchivoPorCasos.put(originalFilename, episodioId)
         println " originalFilename: "+mapArchivoPorCasos
         mapArchivoPorCasos.each{
             println " originalFilename: "+it
         }
    }

    boolean escribirArchivo(byte[] fileBytes, String archivoDestino){ 
    def webRootDir = servletContext.getRealPath("/")        
    def userDir = new File(webRootDir, "/cargarArchivosSosTriaje/"+archivoDestino)
    userDir.mkdirs()
            
        boolean correcto = false; 
            try { 
                OutputStream out = new FileOutputStream(userDir); 
                out.write(fileBytes); 
                out.close();         
                correcto = true; 
            } catch (Exception e) { 
                e.printStackTrace(); 
            }         
            return correcto;
    }
    
}
