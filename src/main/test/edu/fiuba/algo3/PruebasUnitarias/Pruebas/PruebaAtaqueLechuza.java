package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Enemigos.Ataques.AtaqueLechuza;
import edu.fiuba.algo3.models.Cordenada;

public class PruebaAtaqueLechuza {
    @Test
    public void TestPuedeDaniar(){
    List<Defensa> defensas = new ArrayList<>();
        Defensa torreBlanca = mock(Defensa.class);
        Jugador jugador = mock(Jugador.class);

        defensas.add(torreBlanca);

        AtaqueLechuza ataque = new AtaqueLechuza(defensas);

        Cordenada coordenadaMock = mock(Cordenada.class);
        when(torreBlanca.obtenerCordenada()).thenReturn(coordenadaMock);
        when(torreBlanca.getNombre()).thenReturn("");
        when(coordenadaMock.getCoordenadas()).thenReturn("");

        ataque.dañar(jugador);
        verify(torreBlanca, times(1)).destruir();
    }
}
