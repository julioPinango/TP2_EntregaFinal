package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Estados.EstadoEnConstruccion;
import edu.fiuba.algo3.models.Defensas.Estados.EstadoOperativo;

import java.util.HashMap;
import java.util.Map;

public class DefensaFactory
{
    private static Map<String, Defensa> tiposDeTorre = new HashMap<>();


    public static Defensa obtenerDefensa(Cordenada cordenada, String tipo){
        tiposDeTorre.put("Torre Blanca", new TorreBlanca(cordenada,new EstadoEnConstruccion(1)));
        tiposDeTorre.put("Torre Plateada", new TorrePlateada(cordenada,new EstadoEnConstruccion(2)));
        tiposDeTorre.put("Trampa Arenosa", new TrampaArenosa(cordenada,new EstadoOperativo()));
        return (tiposDeTorre.get(tipo));
    }
}
