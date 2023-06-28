package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Enemigos.Ataques.AtaqueHormiga;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormiga;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaHormiga {
    @Test
    public void TestMover(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela1 = mock(Pasarela.class);
        Pasarela pasarela2 = mock(Pasarela.class);
        Cordenada cordenada = mock(Cordenada.class);
        
        when(pasarela2.getCordenada()).thenReturn(cordenada);

        pasarelas.add(pasarela1);
        pasarelas.add(pasarela2);

        Hormiga hormiga = new Hormiga(pasarelas,new MovimientoHormiga());
        hormiga.mover();
        assertEquals(hormiga.getCordenada(),cordenada);
    }

    @Test
    public void TestMoverRalentizado(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela1 = mock(Pasarela.class);
        Pasarela pasarela2 = mock(Pasarela.class);
        Cordenada cordenada = mock(Cordenada.class);
        
        when(pasarela1.getCordenada()).thenReturn(cordenada);

        pasarelas.add(pasarela1);
        pasarelas.add(pasarela2);

        Hormiga hormiga = new Hormiga(pasarelas,new MovimientoHormiga());
        hormiga.ralentizar();
        hormiga.mover();
        assertEquals(hormiga.getCordenada(),cordenada);
    }
    @Test
    public void TestOtorgaCreditos(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Jugador jugador = mock(Jugador.class);

        when(jugador.getHormigasDestruidas()). thenReturn(0);

        Hormiga hormiga = new Hormiga(pasarelas,new MovimientoHormiga());
        hormiga.otorgarCreditos(jugador);

        verify(jugador).getHormigasDestruidas();
        verify(jugador).agregarCreditos(1);
    }

    @Test
    public void TestSumarEnemigoMuerto(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Jugador jugador = mock(Jugador.class);

        Hormiga hormiga = new Hormiga(pasarelas,new MovimientoHormiga());
        hormiga.sumarEnemigoMuerto(jugador);

        verify(jugador).sumarHormigaMuerta();
    }

    @Test
    public void TestOtorga2Creditos(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Jugador jugador = mock(Jugador.class);

        when(jugador.getHormigasDestruidas()). thenReturn(10);

        Hormiga hormiga = new Hormiga(pasarelas,new MovimientoHormiga());
        hormiga.otorgarCreditos(jugador);

        verify(jugador).getHormigasDestruidas();
        verify(jugador).agregarCreditos(2);
    }

    @Test
    public void TestRecibirAtaque(){
        Queue<Pasarela> pasarelas = new LinkedList<>();

        Hormiga hormiga = new Hormiga(pasarelas,new MovimientoHormiga());
        Random random = new Random();

        int numeroAleatorio = random.nextInt(10);

        assertTrue(hormiga.recibirAtaque(numeroAleatorio));
    }

    @Test
    public void TestAtacarJugador(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Jugador jugador = mock(Jugador.class);

        Hormiga hormiga = new Hormiga(pasarelas,new MovimientoHormiga());

        hormiga.definirAtaque(new AtaqueHormiga());

        hormiga.atacarJugador(jugador);

        verify(jugador).recibirAtaque(anyInt());
    }
}
