package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormigaRalentizado;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaMovimientoHormigaRalentizado {
    @Test
    public void TestMovimientoHormigaRalentizado(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela = mock(Pasarela.class);
        pasarelas.add(pasarela);

        MovimientoHormigaRalentizado movimiento = new MovimientoHormigaRalentizado();
        
        assertEquals(pasarelas, movimiento.mover(pasarelas));
    }
}