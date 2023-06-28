package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;

public class TorrePlateada extends Defensa
{
    public TorrePlateada(Cordenada cordenadas,Estado estado)
    {
        this.Costo=20;
        this.RangoAtaque=5;
        this.danio=2;
        this.nombre= "Torre Plateada";
        this.cordenada=cordenadas;
        this.estado=estado;
    }
    
}