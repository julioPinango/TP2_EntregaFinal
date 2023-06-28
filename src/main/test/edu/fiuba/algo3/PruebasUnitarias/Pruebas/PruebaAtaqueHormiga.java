package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Enemigos.Ataques.AtaqueHormiga;

public class PruebaAtaqueHormiga {
    @Test
    public void TestPuedeDaniar(){
        AtaqueHormiga ataque = new AtaqueHormiga();
        Jugador jugador = mock(Jugador.class);
        
        ataque.dañar(jugador);
        verify(jugador).recibirAtaque(1);
    }
}
