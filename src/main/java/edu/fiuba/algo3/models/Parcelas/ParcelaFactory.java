package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;

import java.util.HashMap;
import java.util.*;

public class ParcelaFactory
{
    private static Map<String, Parcela> tiposDeParcelas = new HashMap<>();


    public static Parcela obtenerParcela(Cordenada cordenada, String tipo){
        tiposDeParcelas.put("Rocoso", new Rocoso(cordenada));
        tiposDeParcelas.put("Tierra", new Tierra(cordenada));
        tiposDeParcelas.put("Pasarela", new Pasarela(cordenada));
        return (tiposDeParcelas.get(tipo));
    }
    public static Pasarela obtenerPasarela(Cordenada cordenada)
    {
        return (new Pasarela(cordenada));
    }
}
