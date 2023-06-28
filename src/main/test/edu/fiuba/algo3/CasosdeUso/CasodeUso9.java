package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoAraña;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormiga;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class CasodeUso9 {    
    @Test
    public void Prueba01(){
        Queue<Pasarela> pasarelas = new LinkedList<>();


        Cordenada cordenada = new Cordenada(0, 4);
        Cordenada cordenada1 = new Cordenada(1, 4);
        Cordenada cordenada2 = new Cordenada(2, 4);
        Cordenada cordenada3 = new Cordenada(3, 4);
        Pasarela pasarela = new Pasarela(cordenada);
        Pasarela pasarela1 = new Pasarela(cordenada1);
        Pasarela pasarela2 = new Pasarela(cordenada2);
        Pasarela pasarela3 = new Pasarela(cordenada3);

        pasarelas.add(pasarela);
        pasarelas.add(pasarela1);
        pasarelas.add(pasarela2);
        pasarelas.add(pasarela3);

        Enemigo hormiga = new Hormiga(pasarelas,new MovimientoHormiga());
        

        hormiga.mover();

        assertEquals(hormiga.getCordenada() , cordenada1);
    }
    @Test
    public void Prueba02(){
        Queue<Pasarela> pasarelas = new LinkedList<>();


        Cordenada cordenada = new Cordenada(0, 4);
        Cordenada cordenada1 = new Cordenada(1, 4);
        Cordenada cordenada2 = new Cordenada(2, 4);
        Cordenada cordenada3 = new Cordenada(3, 4);
        Pasarela pasarela = new Pasarela(cordenada);
        Pasarela pasarela1 = new Pasarela(cordenada1);
        Pasarela pasarela2 = new Pasarela(cordenada2);
        Pasarela pasarela3 = new Pasarela(cordenada3);

        pasarelas.add(pasarela);
        pasarelas.add(pasarela1);
        pasarelas.add(pasarela2);
        pasarelas.add(pasarela3);

        var araña=new Araña(pasarelas,new MovimientoAraña());

        araña.mover();

        assertEquals(araña.getCordenada() , cordenada2);
    }
}
