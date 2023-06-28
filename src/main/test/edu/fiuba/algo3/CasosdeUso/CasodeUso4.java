package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.DefensaFactory;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

public class CasodeUso4 {    
    @Test
    public void Prueba01(){        
        Cordenada cordena=new Cordenada(2,1);
        Tierra bloque=new Tierra(cordena);
        Defensa torre=DefensaFactory.obtenerDefensa(cordena,"Torre Blanca");
        assertTrue(bloque.puedoConstruirDefensa(torre)); 
    }
    @Test
    public void Prueba02(){        
        Cordenada cordena=new Cordenada(2,1);
        Pasarela bloque=new Pasarela(cordena);
        Defensa torre=DefensaFactory.obtenerDefensa(cordena,"Torre Blanca");
        assertFalse(bloque.puedoConstruirDefensa(torre)); 
    }
    @Test
    public void Prueba03(){
        Cordenada cordena=new Cordenada(2,1);        
        Rocoso bloque=new Rocoso(cordena);
        Defensa torre=DefensaFactory.obtenerDefensa(cordena,"Torre Blanca");
        assertFalse(bloque.puedoConstruirDefensa(torre)); 
    }
}
