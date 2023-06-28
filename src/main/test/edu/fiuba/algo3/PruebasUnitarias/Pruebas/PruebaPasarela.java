package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaPasarela {
    
    @Test
    public void TestPuedoConstruirDefensa(){
        Cordenada cordenada = mock(Cordenada.class);
        Defensa defensaNueva = mock(Defensa.class);

        when(defensaNueva.puedoConstruirEnPasarela()). thenReturn(true);

        Pasarela pasarela = new Pasarela(cordenada);
        assertTrue(pasarela.puedoConstruirDefensa(defensaNueva));
    }

    @Test
    public void TestNoPuedoConstruirDefensa(){
        Cordenada cordenada = mock(Cordenada.class);
        Defensa defensaNueva = mock(Defensa.class);

        when(defensaNueva.puedoConstruirEnPasarela()). thenReturn(false);

        Pasarela pasarela = new Pasarela(cordenada);
        assertFalse(pasarela.puedoConstruirDefensa(defensaNueva));
    }

    @Test 
    public void TestGetter(){
        Cordenada cordenadaEsperada = mock(Cordenada.class);
        Pasarela pasarela = new Pasarela(cordenadaEsperada);

        assertEquals(cordenadaEsperada,pasarela.getCordenada());
    }

    @Test
    public void TestEquals(){
        Cordenada cordenadaEsperada = mock(Cordenada.class);
        Pasarela pasarela = new Pasarela(cordenadaEsperada);
        Pasarela pasarela2 = new Pasarela(cordenadaEsperada);

        assertTrue(pasarela.equals(pasarela2));
    }

    @Test 
    public void TestNotEquals(){
        Cordenada cordenada1 = mock(Cordenada.class);
        Cordenada cordenada2 = mock(Cordenada.class);
        Pasarela pasarela = new Pasarela(cordenada1);
        Pasarela pasarela2 = new Pasarela(cordenada2);

        assertFalse(pasarela.equals(pasarela2));
    }
}
