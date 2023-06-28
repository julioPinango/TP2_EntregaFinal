package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Turno;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoAraña;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormiga;
import edu.fiuba.algo3.models.Parcelas.Parcela;


public class CasodeUso17 {    
    @Test
    public void Prueba01(){
       
        String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapaReducido.json";
        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosReducido.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path2,path,parser);
        List<List<Enemigo>> enemigosEsperados = new ArrayList<>();
        Mapa mapaLogica=new Mapa(path2,path,parser); //Solo para usar un metodo del mapa
        List<List<String>> mapaEsperado=new ArrayList<>();



       
        // Crear la lista de listas
        
        var camino=mapa.inicializarCaminoDeEnemigos(parser.formarCamino(path));

      var Hormiga=new Hormiga(camino,new MovimientoHormiga());

        var Araña=new Araña(camino,new MovimientoAraña());
        
        // Crear el primer turno y añade a la lista de enemigos
        List<Enemigo> primerTurno = new ArrayList<>();        
        primerTurno.add(Hormiga);
        enemigosEsperados.add(primerTurno);

        // Crear el primer turno y añade a la lista de enemigos
        List<Enemigo> segundoTurno = new ArrayList<>();
        segundoTurno.add(Hormiga);
        segundoTurno.add(Araña);
        enemigosEsperados.add(segundoTurno);

        // Crear la tercera lista y añadirla a la lista de listas
        List<Enemigo> tercerTurno = new ArrayList<>();
        tercerTurno.add(Hormiga);
        tercerTurno.add(Hormiga);
        tercerTurno.add(Araña);
        enemigosEsperados.add(tercerTurno);

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

                Jugador jugador= new Jugador("Julio Pinango");
                Turno turno= new Turno();
                Juego nuevoJuego= new Juego(jugador, mapaObtenido, turno);


                assertEquals(enemigosEsperados,nuevoJuego.getSpaw());
                assertEquals(nuevoJuego.getParcelas(),parcelasEsperadas);
    }
}
