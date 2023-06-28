package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;
import java.util.Random;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Enemigos.Movimientos.Movimiento;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoAraña;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoArañaRalentizado;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Araña extends Enemigo
{
    public Araña(Queue<Pasarela> pasarelas,Movimiento mov)
    {
        this.Energia = 2;
        this.Velocidad = 2;
        this.nombre = "Araña";
        this.pasarelas=pasarelas;
        this.movimiento=mov;
    }

    public void mover() {
        if (pasarelas.size()<3)
        {
            Energia=0;
            llegoAlFinal=true;
        }
        else 
        {
            pasarelas=movimiento.mover(pasarelas);
            this.movimiento=new MovimientoAraña();
        }       

    }
    public void otorgarCreditos(Jugador jugador)
    {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(11);
        

        jugador.agregarCreditos(numeroAleatorio);

    }  

    public void ralentizar() {
        this.movimiento=new MovimientoArañaRalentizado();
    }
}