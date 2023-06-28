package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class PruebaTorreBlanca {
    @Test
    public void TestPuedoAtacar(){
        Estado estado = mock(Estado.class);
        Cordenada cordenada = mock(Cordenada.class);

        when (estado.puedoAtacar()). thenReturn(true);

        TorreBlanca torreBlanca = new TorreBlanca(cordenada, estado);
        assertTrue(torreBlanca.puedoAtacar());
    }

    @Test
    public void TestAtacar(){
        Estado estado = Mockito.mock(Estado.class);
        Cordenada cordenada = Mockito.mock(Cordenada.class);
        List<Enemigo> lista = new ArrayList<Enemigo>();
        Enemigo araña = Mockito.mock(Enemigo.class);
        
        when(araña.getCordenada()).thenReturn(cordenada);
     
        when(araña.getEnergia()).thenReturn(2);
        
        when(araña.recibirAtaque(1)).thenReturn(true);

        when(cordenada.estaEnRango(3, cordenada)).thenReturn(true);

        when(estado.puedoAtacar()).thenReturn(true);

        lista.add(0, araña);

        TorreBlanca torreBlanca = new TorreBlanca(cordenada, estado);
        torreBlanca.atacar(lista);

        verify(estado).puedoAtacar();
        verify(araña,times(2)).getCordenada();
        verify(araña).getEnergia();
        verify(araña).recibirAtaque(1);
        verify(cordenada).estaEnRango(3,araña.getCordenada());
    }

    @Test
    public void TestEstaDestruido(){
        Estado estado = Mockito.mock(Estado.class);
        Cordenada cordenada = Mockito.mock(Cordenada.class);

        when(estado.destruido()).thenReturn(true);

        TorreBlanca torreBlanca = new TorreBlanca(cordenada, estado);
        
        assertTrue(torreBlanca.destruido());
    }

    @Test
    public void TestNoEstaDestruido(){
        Estado estado = Mockito.mock(Estado.class);
        Cordenada cordenada = Mockito.mock(Cordenada.class);

        when(estado.destruido()).thenReturn(false);

        TorreBlanca torreBlanca = new TorreBlanca(cordenada, estado);
        
        assertFalse(torreBlanca.destruido());
    }
}
