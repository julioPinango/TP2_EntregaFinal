package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoArañaRalentizado;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaMovimientoArañaRalentizado {
    @Test
    public void TestMovimientoArañaRalentizado(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Queue<Pasarela> pasarelasEsperadas = new LinkedList<>();
        Pasarela pasarela = mock(Pasarela.class);
        pasarelas.add(pasarela);

        MovimientoArañaRalentizado movimiento = new MovimientoArañaRalentizado();
        
        assertEquals(pasarelasEsperadas, movimiento.mover(pasarelas));
    }
}