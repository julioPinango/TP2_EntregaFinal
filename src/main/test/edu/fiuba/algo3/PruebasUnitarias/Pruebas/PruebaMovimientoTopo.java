package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoTopo;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaMovimientoTopo {
    @Test
    public void TestMovimientoTopoConMenosDe6movimientos(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela = mock(Pasarela.class);
        pasarelas.add(pasarela);
        Queue<Pasarela> pasarelasEsperadas = pasarelas;
        pasarelas.add(pasarela);
        

        MovimientoTopo movimiento = new MovimientoTopo();
        
        assertEquals(pasarelasEsperadas, movimiento.mover(pasarelas,5));
    }

    @Test
    public void TestMovimientoTopoConMasDe5yMenosDe11Movimientos(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela = mock(Pasarela.class);
        pasarelas.add(pasarela);
        Queue<Pasarela> pasarelasEsperadas = pasarelas;
        pasarelas.add(pasarela);
        pasarelas.add(pasarela);
        

        MovimientoTopo movimiento = new MovimientoTopo();
        
        assertEquals(pasarelasEsperadas, movimiento.mover(pasarelas,9));
    }

    @Test
    public void TestMovimientoTopoConMasDe10Movimientos(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela = mock(Pasarela.class);
        pasarelas.add(pasarela);
        Queue<Pasarela> pasarelasEsperadas = pasarelas;
        pasarelas.add(pasarela);
        pasarelas.add(pasarela);
        pasarelas.add(pasarela);
        

        MovimientoTopo movimiento = new MovimientoTopo();
        
        assertEquals(pasarelasEsperadas, movimiento.mover(pasarelas,11));
    }
}
