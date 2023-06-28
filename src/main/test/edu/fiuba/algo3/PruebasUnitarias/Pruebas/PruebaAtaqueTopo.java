package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Turno;
import edu.fiuba.algo3.models.Enemigos.Ataques.AtaqueTopo;

public class PruebaAtaqueTopo {
    @Test
    public void TestPuedeDaniarEnTurnoPar(){
        Turno turno = mock(Turno.class);
        when(turno.esTurnoPar()).thenReturn(true);

        AtaqueTopo ataque = new AtaqueTopo(turno);

        Jugador jugador = mock(Jugador.class);
        
        ataque.dañar(jugador);
        verify(jugador).recibirAtaque(5);
    }

    @Test
    public void TestPuedeDaniarEnTurnoImpar(){
        Turno turno = mock(Turno.class);
        when(turno.esTurnoPar()).thenReturn(false);

        AtaqueTopo ataque = new AtaqueTopo(turno);

        Jugador jugador = mock(Jugador.class);
        
        ataque.dañar(jugador);
        verify(jugador).recibirAtaque(2);
    }
}
