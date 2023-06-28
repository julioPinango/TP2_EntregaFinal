package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;

import edu.fiuba.algo3.models.Enemigos.Movimientos.Movimiento;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoTopo;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoTopoRalentizado;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Topo extends Enemigo
{
    protected int contMovimientos ;

    public Topo(Queue<Pasarela> pasarelas,Movimiento mov)
    {
        this.Energia = 1;
        this.Velocidad = 1; 
        this.nombre = "Topo";
        this.pasarelas=pasarelas;
        this.contMovimientos= 0;
        this.movimiento=mov;
    }

    public void mover() {

        if (pasarelas.size()<=this.movimiento.getVelocidad(contMovimientos)+1)
        {
            Energia=0;
            llegoAlFinal=true;
        }
        else 
        {
            this.pasarelas=movimiento.mover(pasarelas,contMovimientos);
            this.movimiento=new MovimientoTopo();   
        }
        this.contMovimientos++;      

    }
    public boolean recibirAtaque(int danio) {
        return false; 
    }
 

    public void ralentizar() {
        this.movimiento=new MovimientoTopoRalentizado();
    }    
}