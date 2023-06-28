package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoAraña;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaMovimientoAraña {
    @Test
    public void TestMovimientoAraña(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Queue<Pasarela> pasarelasEsperadas = new LinkedList<>();
        Pasarela pasarela = mock(Pasarela.class);
        pasarelas.add(pasarela);
        pasarelas.add(pasarela);

        MovimientoAraña movimiento = new MovimientoAraña();
        
        assertEquals(pasarelasEsperadas, movimiento.mover(pasarelas));
    }
}