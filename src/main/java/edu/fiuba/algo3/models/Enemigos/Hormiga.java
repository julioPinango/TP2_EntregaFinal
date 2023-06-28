package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Enemigos.Movimientos.Movimiento;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormiga;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormigaRalentizado;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Hormiga extends Enemigo
{
    public Hormiga(Queue<Pasarela> pasarelas,Movimiento mov)
    {
        this.Energia = 1;
        this.Velocidad = 1;
        this.nombre = "Hormiga";
        this.pasarelas=pasarelas;
        this.movimiento=mov;
    }
  
  
    public void mover() {

        if (pasarelas.size()==1)
        { 
            Energia=0;
            llegoAlFinal=true;
        }
        else
        { 
            movimiento.mover(pasarelas);
            movimiento=new MovimientoHormiga();
        }
    }

    public void otorgarCreditos(Jugador jugador)
    {
        if(jugador.getHormigasDestruidas()<10)
            jugador.agregarCreditos(1);
        else
        jugador.agregarCreditos(2);

    }   
    public void sumarEnemigoMuerto(Jugador jugador) {
        jugador.sumarHormigaMuerta();
    }

     public void ralentizar() {
        this.movimiento=new MovimientoHormigaRalentizado();
    }


}

