package edu.fiuba.algo3.models.Enemigos.Movimientos;

import java.util.Queue;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class MovimientoArañaRalentizado extends Movimiento{

     public Queue<Pasarela> mover(Queue<Pasarela> cola)
     {     
        cola.poll(); 
        return cola;
     }

}
