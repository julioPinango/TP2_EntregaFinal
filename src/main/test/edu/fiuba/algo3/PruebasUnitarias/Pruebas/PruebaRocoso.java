package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Parcelas.Rocoso;

public class PruebaRocoso {
    
    @Test
    public void TestNuncaPuedoConstruirDefensa(){
        Cordenada cordenada = mock(Cordenada.class);
        Defensa defensaNueva = mock(Defensa.class);

        Rocoso rocoso = new Rocoso(cordenada);

        assertFalse(rocoso.puedoConstruirDefensa(defensaNueva));
    }

    @Test 
    public void TestGetter(){
        Cordenada cordenadaEsperada = mock(Cordenada.class);
        Rocoso rocoso = new Rocoso(cordenadaEsperada);

        assertEquals(cordenadaEsperada,rocoso.getCordenada());
    }

    @Test
    public void TestEquals(){
        Cordenada cordenadaEsperada = mock(Cordenada.class);
        Rocoso rocoso = new Rocoso(cordenadaEsperada);
        Rocoso pasarela2 = new Rocoso(cordenadaEsperada);

        assertTrue(rocoso.equals(pasarela2));
    }

    @Test 
    public void TestNotEquals(){
        Cordenada cordenada1 = mock(Cordenada.class);
        Cordenada cordenada2 = mock(Cordenada.class);
        Rocoso rocoso = new Rocoso(cordenada1);
        Rocoso pasarela2 = new Rocoso(cordenada2);

        assertFalse(rocoso.equals(pasarela2));
    }
}
