package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoTopo;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoTopoRalentizado;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaMovimientoTopoRalentizado {
    @Test
    public void TestMovimientoTopoRalentizadoConMenosDe6movimientos(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela = mock(Pasarela.class);
        pasarelas.add(pasarela);
        Queue<Pasarela> pasarelasEsperadas = pasarelas;

        MovimientoTopoRalentizado movimiento = new MovimientoTopoRalentizado();
        
        assertEquals(pasarelasEsperadas, movimiento.mover(pasarelas,5));
    }

    @Test
    public void TestMovimientoTopoRalentizadoConMasDe5Movimientos(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela = mock(Pasarela.class);
        pasarelas.add(pasarela);
        Queue<Pasarela> pasarelasEsperadas = pasarelas;
        pasarelas.add(pasarela);
        

        MovimientoTopo movimiento = new MovimientoTopo();
        
        assertEquals(pasarelasEsperadas, movimiento.mover(pasarelas,6));
    }
}
