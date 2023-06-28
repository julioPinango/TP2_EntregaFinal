package edu.fiuba.algo3.models.Enemigos.Movimientos;

import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public abstract class Movimiento {

    public Movimiento obtenerMovimiento(int parametro)
    {
        return this;
    }

    public Queue<Pasarela> mover(Queue<Pasarela> cola)
    {
        return cola;
    }

    public Cordenada mover(Cordenada coordenadaObjetivo,Cordenada coordenadaActual)
    {
        return coordenadaActual;
    } 

    public Queue<Pasarela> mover(Queue<Pasarela> cola,int contMovimientos)
    {
        return cola;
    }

    public int getVelocidad(int argumento) {
        return 0;
    }

    

}
