package edu.fiuba.algo3.models.Enemigos.Ataques;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.models.Turno;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Enemigos.Enemigo;


public class AtaqueFactory
{
    private static Map<String, Ataque> tiposDeAtaque = new HashMap<>();


    public static Ataque obtenerAtaque(Enemigo enemigo,Turno turno,List<Defensa> defensas){

        tiposDeAtaque.put("Hormiga", new AtaqueHormiga());
        tiposDeAtaque.put("Araña", new AtaqueAraña());
        tiposDeAtaque.put("Lechuza", new AtaqueLechuza(defensas));
        tiposDeAtaque.put("Topo", new AtaqueTopo(turno));

        return (tiposDeAtaque.get(enemigo.getNombre()));
    }
}