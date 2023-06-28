package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Enemigos.Ataques.AtaqueAraña;

public class PruebaAtaqueAraña {
    //No se me ocurre que mas testearle
    @Test
    public void TestPuedeDaniar(){
        AtaqueAraña ataque = new AtaqueAraña();
        Jugador jugador = mock(Jugador.class);
        
        ataque.dañar(jugador);
        verify(jugador).recibirAtaque(2);
    }
}
