package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormiga;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaMovimientoHormiga {
    @Test
    public void TestMovimientoHormiga(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Queue<Pasarela> pasarelasEsperadas = pasarelas;
        Pasarela pasarela = mock(Pasarela.class);
        pasarelas.add(pasarela);

        MovimientoHormiga movimiento = new MovimientoHormiga();
        
        assertEquals(pasarelasEsperadas, movimiento.mover(pasarelas));
    }
}
