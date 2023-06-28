package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoLechuzaenDiagonal;

public class PruebaMovimientoLechuzaEnDiagonal {
    @Test
    public void TestMovimientoEnDiagonalLechuza(){
        Cordenada cordenada = mock(Cordenada.class);
        Cordenada cordenadaObjetivo = mock(Cordenada.class);

        when(cordenada.getX()). thenReturn(0);
        when(cordenada.getY()). thenReturn(0);
        when(cordenadaObjetivo.getX()). thenReturn(3);
        when(cordenadaObjetivo.getY()). thenReturn(2);

        MovimientoLechuzaenDiagonal movimiento = new MovimientoLechuzaenDiagonal();

        assertEquals(movimiento.mover(cordenadaObjetivo, cordenada),new Cordenada(3, 2));
    }

    @Test
    public void TestMovimientoEnDiagonalLechuzasinLlegarAObjetivo(){
        Cordenada cordenada = mock(Cordenada.class);
        Cordenada cordenadaObjetivo = mock(Cordenada.class);

        when(cordenada.getX()). thenReturn(5);
        when(cordenada.getY()). thenReturn(3);
        when(cordenadaObjetivo.getX()). thenReturn(11);
        when(cordenadaObjetivo.getY()). thenReturn(15);

        MovimientoLechuzaenDiagonal movimiento = new MovimientoLechuzaenDiagonal();

        assertEquals(movimiento.mover(cordenadaObjetivo, cordenada),new Cordenada(10, 8));
    }
}
