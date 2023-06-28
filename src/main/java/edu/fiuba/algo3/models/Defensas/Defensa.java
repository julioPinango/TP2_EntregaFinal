package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;
import edu.fiuba.algo3.models.Defensas.Estados.EstadoDestruido;
import edu.fiuba.algo3.models.Defensas.Estados.EstadoOperativo;

import java.util.List;

public abstract class Defensa
{
    protected Cordenada cordenada;

    protected int Costo;
    protected int RangoAtaque;
    protected int danio ;
    protected Estado estado;
    protected String nombre;

    public String getNombre(){
        return nombre;
    }
    public int getCosto(){
        return Costo;
    }

    public boolean puedoConstruirEnPasarela(){
        return false;
    }

    public boolean puedoConstruirEnTierra(Boolean estaLibre){
        return estaLibre;
    }
    
    public void atacar(List<Enemigo> enemigos){
        
        if (this.estado.puedoAtacar()) {
            this.estado=new EstadoOperativo();
            for (Enemigo enemigo : enemigos) {

                if(cordenada.estaEnRango(RangoAtaque, enemigo.getCordenada()) && enemigo.getEnergia()>0)
                { 
                    if(enemigo.recibirAtaque(danio)){
                        var log = Log.obtenetInstancia();
                        log.imprimirAtaque(this,enemigo,enemigo.getCordenada());
                        break;
                    }
                }
            }
        }
    }

    public boolean destruido(){
        return this.estado.destruido();
    }

    public void destruir()
    {
        this.estado=new EstadoDestruido();
    }
    
    public Cordenada obtenerCordenada(){
        return this.cordenada;
    }
    public boolean puedoAtacar(){
        return(this.estado.puedoAtacar());
    }
    public boolean enContruccion() {
        return estado.enContruccion();
    }
}
