package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;

public class TorreBlanca extends Defensa{
    public TorreBlanca(Cordenada cordenadas,Estado estado){
        this.Costo=10;
        this.RangoAtaque=3;
        this.danio=1;
        this.nombre= "Torre Blanca";
        this.cordenada=cordenadas;
        this.estado=estado;
    }    
}