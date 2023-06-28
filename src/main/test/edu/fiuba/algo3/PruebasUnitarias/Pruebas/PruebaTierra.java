package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Parcelas.Tierra;

public class PruebaTierra {
    
    @Test
    public void TestPuedoConstruirDefensa(){
        Cordenada cordenada = mock(Cordenada.class);
        Defensa defensaNueva = mock(Defensa.class);
        boolean libre = true;

        when(defensaNueva.puedoConstruirEnTierra(libre)). thenReturn(libre);

        Tierra tierra = new Tierra(cordenada);
        assertTrue(tierra.puedoConstruirDefensa(defensaNueva));
    }

    @Test
    public void TestNoPuedoConstruirEstaDefensa(){
        Cordenada cordenada = mock(Cordenada.class);
        Defensa defensaNueva = mock(Defensa.class);
        boolean libre = true;

        when(defensaNueva.puedoConstruirEnTierra(libre)). thenReturn(false);

        Tierra tierra = new Tierra(cordenada);
        assertFalse(tierra.puedoConstruirDefensa(defensaNueva));
    }

    @Test
    public void TestNoPuedoConstruirNingunaDefensa(){
        Cordenada cordenada = mock(Cordenada.class);
        Defensa defensaNueva = mock(Defensa.class);
        boolean libre = false;

        when(defensaNueva.puedoConstruirEnTierra(libre)). thenReturn(libre);

        Tierra tierra = new Tierra(cordenada);
        assertFalse(tierra.puedoConstruirDefensa(defensaNueva));
    }

    @Test 
    public void TestGetter(){
        Cordenada cordenadaEsperada = mock(Cordenada.class);
        Tierra tierra = new Tierra(cordenadaEsperada);

        assertEquals(cordenadaEsperada,tierra.getCordenada());
    }

    @Test
    public void TestEquals(){
        Cordenada cordenadaEsperada = mock(Cordenada.class);
        Tierra tierra = new Tierra(cordenadaEsperada);
        Tierra pasarela2 = new Tierra(cordenadaEsperada);

        assertTrue(tierra.equals(pasarela2));
    }

    @Test 
    public void TestNotEquals(){
        Cordenada cordenada1 = mock(Cordenada.class);
        Cordenada cordenada2 = mock(Cordenada.class);
        Tierra tierra = new Tierra(cordenada1);
        Tierra pasarela2 = new Tierra(cordenada2);

        assertFalse(tierra.equals(pasarela2));
    }
}
