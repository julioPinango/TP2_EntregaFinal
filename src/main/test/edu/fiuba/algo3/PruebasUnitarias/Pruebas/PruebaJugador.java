package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Jugador;

public class PruebaJugador {
    @Test
    public void TestGetters() {
        Jugador jugador = new Jugador("Nombre");
        
        assertEquals(jugador.getVida(),20);
        assertEquals(jugador.getCreditos(),100);
        assertEquals(jugador.getNombre(),"Nombre");
    }

    @Test
    public void TestCreditosSuficientes(){
        Jugador jugador = new Jugador("Nombre");

        assertTrue(jugador.creditosSuficientes(70));
    }

    @Test
    public void TestJugadorNoDerrotado(){
        Jugador jugador = new Jugador("Nombre");
        jugador.recibirAtaque(15);
        assertFalse(jugador.jugadorDerrotado());
    }

    @Test
    public void TestJugadorDerrotado(){
        Jugador jugador = new Jugador("Nombre");
        jugador.recibirAtaque(20);
        assertTrue(jugador.jugadorDerrotado());
    }

    @Test
    public void TestMata2Hormigas(){
        Jugador jugador = new Jugador("Nombre");

        jugador.sumarHormigaMuerta();
        jugador.sumarHormigaMuerta();

        assertEquals(2, jugador.getHormigasDestruidas());
    }
}
