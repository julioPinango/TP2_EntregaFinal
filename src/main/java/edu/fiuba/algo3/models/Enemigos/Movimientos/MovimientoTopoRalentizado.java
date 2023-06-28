package edu.fiuba.algo3.models.Enemigos.Movimientos;

import java.util.Queue;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class MovimientoTopoRalentizado extends Movimiento{

     public Queue<Pasarela> mover(Queue<Pasarela> cola,int contMovimientos)
     {   
         if(contMovimientos>5)              
                  cola.poll(); 

         return cola;
     }

}
