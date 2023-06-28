package edu.fiuba.algo3.models.Enemigos.Movimientos;

import edu.fiuba.algo3.models.Cordenada;

public class MovimientoLechuzaenDiagonal extends Movimiento{

    public Cordenada mover(Cordenada coordenadaObjetivo,Cordenada coordenadaActual)
    {       
        int distanciaX = coordenadaObjetivo.getX() - coordenadaActual.getX();
        int distanciaY = coordenadaObjetivo.getY() - coordenadaActual.getY();

        // Calcular el movimiento en X
        int pasoX = (distanciaX > 0) ? Math.min(distanciaX, 5) : Math.max(distanciaX, -5);

        // Calcular el movimiento en Y
        int pasoY = (distanciaY > 0) ? Math.min(distanciaY, 5) : Math.max(distanciaY, -5);

        int newCoordenadaX = coordenadaActual.getX() + pasoX;
        int newCoordenadaY = coordenadaActual.getY() + pasoY;  

        return new Cordenada(newCoordenadaX, newCoordenadaY);
    }

}
