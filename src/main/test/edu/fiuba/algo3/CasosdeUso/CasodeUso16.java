package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Parcelas.Parcela;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CasodeUso16 {    
    @Test
    public void Prueba01(){

                String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapaReducido.json";
                String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosReducido.json";
                Parser parser = new Parser();
                Mapa mapaLogica=new Mapa(path2,path,parser); //Solo para usar un metodo del mapa
                List<List<String>> mapaEsperado=new ArrayList<>();

                // Crear la primera lista y añadirla a la lista de listas
                List<String> primeraLista = new ArrayList<>();
                primeraLista.add("Rocoso");
                primeraLista.add("Pasarela");
                primeraLista.add("Tierra");
                mapaEsperado.add(primeraLista);
        
                // Crear la segunda lista y añadirla a la lista de listas
                List<String> segundaLista = new ArrayList<>();
                segundaLista.add("Tierra");
                segundaLista.add("Pasarela");
                segundaLista.add("Tierra");
                mapaEsperado.add(segundaLista);
        
                // Crear la tercera lista y añadirla a la lista de listas
                List<String> terceraLista = new ArrayList<>();
                terceraLista.add("Tierra");
                terceraLista.add("Pasarela");
                terceraLista.add("Tierra");
                mapaEsperado.add(terceraLista);
            
                Map<Cordenada, Parcela> parcelasEsperadas=mapaLogica.inicializarParcelas(mapaEsperado); //Uso metodo de un mapa para convertirlo en objetos validos

                Mapa mapaObtenido=new Mapa(path2,path,parser);

                assertEquals(mapaObtenido.getParcelas(),parcelasEsperadas);
    }
}
