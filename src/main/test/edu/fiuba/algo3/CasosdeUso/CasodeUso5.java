package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.DefensaFactory;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormiga;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class CasodeUso5 {    
    @Test
    public void Prueba01(){
        
        //Caso Negativo

        Cordenada cordenaTorre=new Cordenada(2,2);
        Cordenada cordenaPasarela=new Cordenada(2,1);

        Queue<Pasarela> pasarelas = new LinkedList<>();
        var pasarela=new Pasarela(cordenaPasarela);
        pasarelas.add(pasarela);

        var enemigo=new Hormiga(pasarelas,new MovimientoHormiga());
        Defensa torre=DefensaFactory.obtenerDefensa(cordenaTorre,"Torre Blanca");

        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(enemigo);

        int energiaEnemigo=enemigo.getEnergia();
        torre.atacar(enemigos);        
        torre.atacar(enemigos);
        int energiaEnemigoAtacado=enemigo.getEnergia();
        assertNotEquals(energiaEnemigo,energiaEnemigoAtacado);

    }
    @Test
    public void Prueba02(){
        
        //Caso Positivo       
        Cordenada cordenaTorre=new Cordenada(2,2);
        Cordenada cordenaPasarela=new Cordenada(6,1);
        Queue<Pasarela> pasarelas = new LinkedList<>();

        var pasarela=new Pasarela(cordenaPasarela);
        pasarelas.add(pasarela);
        
        var enemigo=new Hormiga(pasarelas,new MovimientoHormiga());

        Defensa torre=DefensaFactory.obtenerDefensa(cordenaTorre,"Torre Blanca");


        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(enemigo);

        int energiaEnemigo=enemigo.getEnergia();
        torre.atacar(enemigos);
        torre.atacar(enemigos);        
        int energiaEnemigoAtacado=enemigo.getEnergia();

        assertEquals(energiaEnemigo,energiaEnemigoAtacado);
    }
}
