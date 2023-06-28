package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Turno;

public class PruebaJuego {
    @Test
    public void TestColocarDefensas(){
        Mapa mapa = mock(Mapa.class);
        Jugador jugador = mock(Jugador.class);
        Turno turno = mock(Turno.class);

        when (mapa.colocarDefensaEnEstaPosicion(5, 
        7, "hola",jugador)). thenReturn (true);      
            
        Juego juego = new Juego(jugador, mapa, turno);

        assertTrue(juego.colocarDefensas(5,7,"hola"));
    }

    @Test
    public void TestNoSePuedeColocarDefensas(){
        Mapa mapa = mock(Mapa.class);
        Jugador jugador = mock(Jugador.class);
        Turno turno = mock(Turno.class);

        when (mapa.colocarDefensaEnEstaPosicion(5, 
        7, "hola",jugador)). thenReturn (false);    
            
        Juego juego = new Juego(jugador, mapa, turno);

        assertFalse(juego.colocarDefensas(5,7,"hola"));
    }

    @Test
    public void TestGetTurno(){
        Mapa mapa = mock(Mapa.class);
        Jugador jugador = mock(Jugador.class);
        Turno turno = mock(Turno.class);

        when (turno.getTurno()). thenReturn (5);      
            
        Juego juego = new Juego(jugador, mapa, turno);

        assertEquals(juego.getTurno(),5);
    }

    @Test
    public void TestRealizarTurnosYPierde(){
        Mapa mapa = mock(Mapa.class);
        Jugador jugador = mock(Jugador.class);
        Turno turno = mock(Turno.class);

        when (jugador.jugadorDerrotado()). thenReturn (true);      
            
        Juego juego = new Juego(jugador, mapa, turno);
        juego.realizarTurno();
        
        verify(mapa).realizarTurno(jugador,turno);
        verify(jugador,times(2)).jugadorDerrotado();
    }

    @Test
    public void TestRealizarTurnosYNoPierde(){
        Mapa mapa = mock(Mapa.class);
        Jugador jugador = mock(Jugador.class);
        Turno turno = mock(Turno.class);

        when (jugador.jugadorDerrotado()). thenReturn (false);  
        when (mapa.quedanEnemigos()). thenReturn (true); 
            
        Juego juego = new Juego(jugador, mapa, turno);
        juego.realizarTurno();
        
        verify(mapa).realizarTurno(jugador,turno);
        verify(jugador,times(1)).jugadorDerrotado();
        verify(mapa).quedanEnemigos();
        verify(turno).pasarTurno();
    }
    
}
