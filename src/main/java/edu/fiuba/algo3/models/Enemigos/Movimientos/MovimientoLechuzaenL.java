package edu.fiuba.algo3.models.Enemigos.Movimientos;

import edu.fiuba.algo3.models.Cordenada;

public class MovimientoLechuzaenL extends Movimiento{

    public Movimiento obtenerMovimiento(int Energia)
    {
        Integer mitadEnergia = 2;
        if (Energia < mitadEnergia) 
            return new MovimientoLechuzaenDiagonal();

        return this;
    }

    public Cordenada mover(Cordenada coordenadaObjetivo,Cordenada coordenadaActual)
    {
            // Mover en forma de L hacia la meta
            int movimientosX = 2;
            int movimientosY = 3;

            int newCoordenadaX = coordenadaActual.getX();
            int newCoordenadaY = coordenadaActual.getY();

            if (coordenadaActual.getX() < coordenadaObjetivo.getX()) 
                newCoordenadaX=(coordenadaActual.getX() + movimientosX);
            else 
                newCoordenadaX=(coordenadaActual.getX() - movimientosX);                

            if (coordenadaActual.getY() < coordenadaObjetivo.getY())
                newCoordenadaY=(coordenadaActual.getY() + movimientosY);
            else 
                newCoordenadaY=(coordenadaActual.getY() - movimientosY);            
            

            return new Cordenada(newCoordenadaX, newCoordenadaY);
    }

}
