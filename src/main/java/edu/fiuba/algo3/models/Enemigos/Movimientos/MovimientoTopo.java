package edu.fiuba.algo3.models.Enemigos.Movimientos;

import java.util.Queue;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class MovimientoTopo extends Movimiento{

     public Queue<Pasarela> mover(Queue<Pasarela> cola,int contMovimientos)
     {   
         int Velocidad=0;

         if(contMovimientos<6)
               Velocidad=1;
         else if (contMovimientos>5 && contMovimientos<11)
               Velocidad=2;
         else
               Velocidad=3;         
         
         for (var i =0; i<Velocidad; i++)
               cola.poll();  
               
         return cola;
     }

     public int getVelocidad(int contMovimientos)
     {
            if(contMovimientos<6)
                  return 1;
            else if (contMovimientos>5 && contMovimientos<11)
                  return 2;
            else
                  return 3;               
     }
}
