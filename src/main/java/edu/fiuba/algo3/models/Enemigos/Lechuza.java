package edu.fiuba.algo3.models.Enemigos;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Enemigos.Movimientos.Movimiento;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Lechuza extends Enemigo
{
    private Cordenada coordenadaActual;
    private Cordenada coordenadaObjetivo;

    public Lechuza(Queue<Pasarela> pasarelas,Movimiento mov)
    {
        this.Energia = 5;
        this.Velocidad = 5;
        this.nombre = "Lechuza";
        this.pasarelas=pasarelas;
        this.movimiento=mov;

        List<Pasarela> listaPasarelas = new ArrayList<>(pasarelas);
        int tamaño = listaPasarelas.size();
        
        coordenadaActual=listaPasarelas.get(0).getCordenada();

        coordenadaObjetivo = listaPasarelas.get(tamaño - 1).getCordenada();
    }

    public void mover() {
        if (Cordenada.calcularDistancia(coordenadaActual.getX(), coordenadaActual.getY(),
         coordenadaObjetivo.getX(), coordenadaObjetivo.getY())<6)
            {
                Energia=0;
                llegoAlFinal=true;
            }
        else 
            coordenadaActual=movimiento.mover(coordenadaObjetivo,coordenadaActual);          
    }

    public Cordenada getCordenada() {
        return coordenadaActual;
    }

    public boolean recibirAtaque(int danio) {
        Energia=Energia-danio;        
        
        this.movimiento=movimiento.obtenerMovimiento(Energia);

        return true;
    }
}
