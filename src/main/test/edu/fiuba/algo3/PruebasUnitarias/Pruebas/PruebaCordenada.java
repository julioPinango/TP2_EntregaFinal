package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Cordenada;

public class PruebaCordenada {

    @Test
    public void TestDistanciaCorrecta(){
        int distancia = Cordenada.calcularDistancia(0, 0, 1, 2);

        assertEquals(distancia,3);
    }

    @Test
    public void TestEstaEnRango(){
        Cordenada cordenada = new Cordenada(0, 0);
        Cordenada cordenada2 = new Cordenada(1,2);

        assertTrue(cordenada.estaEnRango(3, cordenada2));
    }

    @Test
    public void TestNoEstaEnRango(){
        Cordenada cordenada = new Cordenada(0, 0);
        Cordenada cordenada2 = new Cordenada(2,2);

        assertFalse(cordenada.estaEnRango(3, cordenada2));
    }

    @Test
    public void TestEquals(){
        Cordenada cordenada1 = new Cordenada(0, 0);
        Cordenada cordenada2 = new Cordenada(0, 0);

        assertTrue(cordenada1.equals(cordenada2));
    }

    @Test
    public void TestNotEquals(){
        Cordenada cordenada1 = new Cordenada(0, 0);
        Cordenada cordenada2 = new Cordenada(7, 0);

        assertFalse(cordenada1.equals(cordenada2));
    }

}
