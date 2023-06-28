package edu.fiuba.algo3.models.Enemigos;

import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Enemigos.Movimientos.*;

import java.util.*;

public class EnemigoFactory
{
    private static Map<String, Enemigo> tiposDeEnemigos = new HashMap<>();


    public static Enemigo obtenerEnemigo(Queue<Pasarela> pasarelas, String tipo){

        Queue<Pasarela> copiaPasarelas = new LinkedList<>(pasarelas);

        tiposDeEnemigos.put("hormiga", new Hormiga(copiaPasarelas,new MovimientoHormiga()));
        tiposDeEnemigos.put("arana", new Araña(copiaPasarelas,new MovimientoAraña()));
        tiposDeEnemigos.put("lechuza", new Lechuza(copiaPasarelas,new MovimientoLechuzaenL()));
        tiposDeEnemigos.put("topo", new Topo(copiaPasarelas,new MovimientoTopo()));

        return (tiposDeEnemigos.get(tipo));
    }
}