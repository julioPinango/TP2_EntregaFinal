package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TrampaArenosa;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;
import edu.fiuba.algo3.models.Defensas.Estados.EstadoOperativo;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Tierra;

public class PruebaTrampaArenosa {
    @Test
    public void TestPuedeAtacar(){
        Cordenada cordenada = mock(Cordenada.class);
        Estado estado = mock(Estado.class);

        when(estado.puedoAtacar()). thenReturn(true);

        TrampaArenosa trampa = new TrampaArenosa(cordenada, estado);
        assertTrue(trampa.puedoAtacar());
    }

    @Test
    public void TestNoPuedeAtacar(){
        Cordenada cordenada = mock(Cordenada.class);
        Estado estado = mock(Estado.class);

        when(estado.puedoAtacar()). thenReturn(false);

        TrampaArenosa trampa = new TrampaArenosa(cordenada, estado);
        assertFalse(trampa.puedoAtacar());
    }
    
    @Test
    public void TestAtacar(){
        Cordenada cordenada = mock(Cordenada.class);
        Cordenada otraCordenada = mock(Cordenada.class);
        when(cordenada.estaEnRango(0,otraCordenada)).thenReturn(true);
        Estado estado = mock(Estado.class);

        List<Enemigo> lista = new ArrayList<Enemigo>();
        Enemigo araña = Mockito.mock(Enemigo.class);
        when(araña.getCordenada()).thenReturn(otraCordenada);
        lista.add(araña);

        TrampaArenosa trampa = new TrampaArenosa(cordenada, estado);
        trampa.atacar(lista);
        verify(araña).ralentizar();
    }

    @Test
    public void TestEstaDestruido(){
        Cordenada cordenada = mock(Cordenada.class);
        Estado estado = mock(Estado.class);

        when(estado.destruido()).thenReturn(true);

        TrampaArenosa trampa = new TrampaArenosa(cordenada, estado);
        assertTrue(trampa.destruido());
    }

    @Test
    public void TestNoEstaDestruido(){
        Cordenada cordenada = mock(Cordenada.class);
        Estado estado = mock(Estado.class);

        when(estado.destruido()).thenReturn(false);

        TrampaArenosa trampa = new TrampaArenosa(cordenada, estado);
        assertFalse(trampa.destruido());
    }
    
    @Test
    public void TestSepuedeConstruirUnaTrampaEncimadeOtra()
    {
        Cordenada cordenada = mock(Cordenada.class);
        Estado estado = mock(EstadoOperativo.class);
        Defensa defensaNueva = new TrampaArenosa(cordenada, estado);
        Defensa defensaNueva2 = new TrampaArenosa(cordenada, estado);

        Pasarela camino = new Pasarela(cordenada);
        camino.puedoConstruirDefensa(defensaNueva);
        assertTrue(camino.puedoConstruirDefensa(defensaNueva2)); 
    }

}
