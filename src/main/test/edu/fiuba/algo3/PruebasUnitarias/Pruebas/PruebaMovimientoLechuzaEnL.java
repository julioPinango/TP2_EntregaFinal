package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoLechuzaenL;

public class PruebaMovimientoLechuzaEnL {
    @Test
    public void TestMovimientoLechuzaEnL(){
        Cordenada cordenada = mock(Cordenada.class);
        Cordenada cordenadaObjetivo = mock(Cordenada.class);
        when(cordenada.getX()). thenReturn(0);
        when(cordenada.getY()). thenReturn(0);
        when(cordenadaObjetivo.getX()). thenReturn(2);
        when(cordenadaObjetivo.getY()). thenReturn(3);

        MovimientoLechuzaenL movimiento = new MovimientoLechuzaenL();

        assertEquals(movimiento.mover(cordenadaObjetivo,cordenada), new Cordenada(2, 3));
    }

    @Test
    public void TestMovimientoLechuzaEnLPeroNoLLegaAObjetivo(){
        Cordenada cordenada = mock(Cordenada.class);
        Cordenada cordenadaObjetivo = mock(Cordenada.class);
        when(cordenada.getX()). thenReturn(0);
        when(cordenada.getY()). thenReturn(0);
        when(cordenadaObjetivo.getX()). thenReturn(4);
        when(cordenadaObjetivo.getY()). thenReturn(6);

        MovimientoLechuzaenL movimiento = new MovimientoLechuzaenL();
        
        assertEquals(movimiento.mover(cordenadaObjetivo,cordenada), new Cordenada(2, 3));
    }

    @Test
    public void TestMovimientoLechuzaEnLSePasaYSeVuelveASuPosicionAnterior(){
        Cordenada cordenada = mock(Cordenada.class);
        Cordenada cordenadaObjetivo = mock(Cordenada.class);
        when(cordenada.getX()). thenReturn(0);
        when(cordenada.getY()). thenReturn(0);
        when(cordenadaObjetivo.getX()). thenReturn(1);
        when(cordenadaObjetivo.getY()). thenReturn(2);

        MovimientoLechuzaenL movimiento = new MovimientoLechuzaenL();
        
        cordenada = movimiento.mover(cordenadaObjetivo,cordenada);
        assertEquals(cordenada.getX(),2);
        assertEquals(cordenada.getY(),3);
        assertEquals(movimiento.mover(cordenadaObjetivo,cordenada), new Cordenada(0, 0));
        //ESTO FUNCIONA MAL, DEBERIA BUSCAR LA MANERA DE LLEGAR A LA TORRE
    }
}
