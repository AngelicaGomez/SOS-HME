package triaje

class TriajeService {

    static transactional = true

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
}
