package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.EnemigoFactory;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Enemigos.Lechuza;
import edu.fiuba.algo3.models.Enemigos.Topo;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoAraña;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormiga;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoLechuzaenL;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoTopo;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaEnemigoFactory {
    @Test
    public void TestGetArana(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela1 = mock(Pasarela.class);
        Pasarela pasarela2 = mock(Pasarela.class);
        
        pasarelas.add(pasarela1); pasarelas.add(pasarela2);

        assertEquals(EnemigoFactory.obtenerEnemigo(pasarelas, "arana"),
        new Araña(pasarelas, new MovimientoAraña()));
    }

    @Test
    public void TestGetHormiga(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela1 = mock(Pasarela.class);
        Pasarela pasarela2 = mock(Pasarela.class);
        
        pasarelas.add(pasarela1); pasarelas.add(pasarela2);

        assertEquals(EnemigoFactory.obtenerEnemigo(pasarelas, "hormiga"),
        new Hormiga(pasarelas, new MovimientoHormiga()));
    }

    @Test
    public void TestGetLechuza(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela1 = mock(Pasarela.class);
        Pasarela pasarela2 = mock(Pasarela.class);
        
        pasarelas.add(pasarela1); pasarelas.add(pasarela2);

        assertEquals(EnemigoFactory.obtenerEnemigo(pasarelas, "lechuza"),
        new Lechuza(pasarelas, new MovimientoLechuzaenL()));
    }

    @Test
    public void TestGetTopo(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela1 = mock(Pasarela.class);
        Pasarela pasarela2 = mock(Pasarela.class);
        
        pasarelas.add(pasarela1); pasarelas.add(pasarela2);

        assertEquals(EnemigoFactory.obtenerEnemigo(pasarelas, "topo"),
        new Topo(pasarelas, new MovimientoTopo()));
    }
}
