package edu.fiuba.algo3.models.Enemigos.Movimientos;

import java.util.Queue;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class MovimientoAraña extends Movimiento{

     public Queue<Pasarela> mover(Queue<Pasarela> cola)
     {
        cola.poll();        
        cola.poll(); 
        return cola;
     }

}
