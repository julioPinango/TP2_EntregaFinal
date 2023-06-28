package edu.fiuba.algo3.models.Defensas;

import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class TrampaArenosa extends Defensa{

    private int contadorTurnos;

    public TrampaArenosa(Cordenada cordenadas,Estado estado){
        this.Costo=25;
        this.RangoAtaque=0;
        this.danio=0;
        this.nombre= "Trampa Arenosa";
        this.contadorTurnos=3;
        this.cordenada=cordenadas;
        this.estado=estado;
    }

    public void atacar(List<Enemigo> enemigos){ 

        for (Enemigo enemigo : enemigos) {
            if(cordenada.estaEnRango(RangoAtaque, enemigo.getCordenada())){
                 enemigo.ralentizar(); 
            }           
        }

        contadorTurnos=contadorTurnos-1;

        if(contadorTurnos==0)
            destruir();
    }
    
    public boolean puedoConstruirEnPasarela(){
        return true;
    }

    public boolean puedoConstruirEnTierra(Boolean estaLibre){
        return false;
    }
    
}