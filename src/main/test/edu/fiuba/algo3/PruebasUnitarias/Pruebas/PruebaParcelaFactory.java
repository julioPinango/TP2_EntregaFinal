package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Parcelas.ParcelaFactory;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

public class PruebaParcelaFactory {
    @Test
    public void TestGetRocoso(){
        Cordenada cordenada = mock(Cordenada.class);
        
        assertEquals(ParcelaFactory.obtenerParcela(cordenada,"Rocoso"),new Rocoso(cordenada));
    }

    @Test
    public void TestGetTierra(){
        Cordenada cordenada = mock(Cordenada.class);
        
        assertEquals(ParcelaFactory.obtenerParcela(cordenada,"Tierra"),new Tierra(cordenada));
    }

    @Test
    public void TestGetPasarela(){
        Cordenada cordenada = mock(Cordenada.class);
        
        assertEquals(ParcelaFactory.obtenerParcela(cordenada,"Pasarela"),new Pasarela(cordenada));
    }
}
