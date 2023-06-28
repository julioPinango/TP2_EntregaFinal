package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.DefensaFactory;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoAraña;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormiga;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class CasodeUso2 {    
    @Test
    public void Prueba01(){
        Cordenada cordenada1 = new Cordenada(0, 0);
        Cordenada cordenada2 = new Cordenada(0, 1);
        Cordenada cordenada3 = new Cordenada(0, 2);

        Cordenada cordenada4 = new Cordenada(1, 0);
        Cordenada cordenada5 = new Cordenada(1, 1);
        Cordenada cordenada6 = new Cordenada(1, 2);

        Cordenada cordenada7 = new Cordenada(2, 0);
        Cordenada cordenada8 = new Cordenada(2, 1);
        Cordenada cordenada9 = new Cordenada(2, 2);
        
        var Pasarela1=new Pasarela(cordenada1);
        var Pasarela2=new Pasarela(cordenada2);
        var Pasarela3=new Pasarela(cordenada3);
        var Pasarela4=new Pasarela(cordenada4);
        var Pasarela5=new Pasarela(cordenada5);
        var Pasarela6=new Pasarela(cordenada6);
        var Pasarela7=new Pasarela(cordenada7);
        var Pasarela8=new Pasarela(cordenada8);
        var Pasarela9=new Pasarela(cordenada9);

        Queue<Pasarela> pasarelas=new LinkedList<>();
        pasarelas.add(Pasarela1);
        pasarelas.add(Pasarela2);
        pasarelas.add(Pasarela3);
        pasarelas.add(Pasarela4);
        pasarelas.add(Pasarela5);
        pasarelas.add(Pasarela6);
        pasarelas.add(Pasarela7);
        pasarelas.add(Pasarela8);
        pasarelas.add(Pasarela9);

        Cordenada cordenadatorre= new Cordenada(1, 1);

        Defensa torre=DefensaFactory.obtenerDefensa(cordenadatorre,"Torre Plateada");


        var Araña=new Araña(pasarelas,new MovimientoAraña());
        List<Enemigo> listaEnemigos = new ArrayList<>();
        listaEnemigos.add(Araña);

        int vidaEnemigoEsperada=listaEnemigos.get(0).getEnergia();
        
        torre.atacar(listaEnemigos);
        assertEquals(vidaEnemigoEsperada, listaEnemigos.get(0).getEnergia());
       
        torre.atacar(listaEnemigos);
        assertEquals(vidaEnemigoEsperada, listaEnemigos.get(0).getEnergia());

        vidaEnemigoEsperada=vidaEnemigoEsperada-2; 
        torre.atacar(listaEnemigos);
        assertEquals(vidaEnemigoEsperada, listaEnemigos.get(0).getEnergia());
    }
    @Test
    public void Prueba02(){
        Cordenada cordenada1 = new Cordenada(0, 0);
        Cordenada cordenada2 = new Cordenada(0, 1);
        Cordenada cordenada3 = new Cordenada(0, 2);

        Cordenada cordenada4 = new Cordenada(1, 0);
        Cordenada cordenada5 = new Cordenada(1, 1);
        Cordenada cordenada6 = new Cordenada(1, 2);

        Cordenada cordenada7 = new Cordenada(2, 0);
        Cordenada cordenada8 = new Cordenada(2, 1);
        Cordenada cordenada9 = new Cordenada(2, 2);
        
        var Pasarela1=new Pasarela(cordenada1);
        var Pasarela2=new Pasarela(cordenada2);
        var Pasarela3=new Pasarela(cordenada3);
        var Pasarela4=new Pasarela(cordenada4);
        var Pasarela5=new Pasarela(cordenada5);
        var Pasarela6=new Pasarela(cordenada6);
        var Pasarela7=new Pasarela(cordenada7);
        var Pasarela8=new Pasarela(cordenada8);
        var Pasarela9=new Pasarela(cordenada9);

        Queue<Pasarela> pasarelas=new LinkedList<>();
        pasarelas.add(Pasarela1);
        pasarelas.add(Pasarela2);
        pasarelas.add(Pasarela3);
        pasarelas.add(Pasarela4);
        pasarelas.add(Pasarela5);
        pasarelas.add(Pasarela6);
        pasarelas.add(Pasarela7);
        pasarelas.add(Pasarela8);
        pasarelas.add(Pasarela9);

        Cordenada cordenadatorre= new Cordenada(1, 1);

        Defensa torre=DefensaFactory.obtenerDefensa(cordenadatorre,"Torre Blanca");

          var hormiga=new Hormiga(pasarelas,new MovimientoHormiga());

        List<Enemigo> listaEnemigos = new ArrayList<>();
        listaEnemigos.add(hormiga);

        int vidaEnemigoEsperada=listaEnemigos.get(0).getEnergia();
        
        torre.atacar(listaEnemigos);
        assertEquals(vidaEnemigoEsperada, listaEnemigos.get(0).getEnergia());

        vidaEnemigoEsperada--; 
        torre.atacar(listaEnemigos);
        assertEquals(vidaEnemigoEsperada, listaEnemigos.get(0).getEnergia());
    }
}
