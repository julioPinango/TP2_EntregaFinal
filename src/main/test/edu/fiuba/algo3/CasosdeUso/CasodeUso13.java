package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.fiuba.algo3.models.Parser;

public class CasodeUso13 {    
    @Test
    public void Prueba01()throws Exception{
      
       String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosRoto.json";
        Parser parser = new Parser();

       assertThrows(Exception.class, () -> {parser.desglosarEnemigos(path2);});
    }
}
