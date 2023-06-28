package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Turno;


public class CasodeUso8 {    
    @Test
    public void Prueba01(){
        
        String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosHormiga.json";
        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapaReducido.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
    
        Jugador jugador=new Jugador("Juan Cruz");

        Turno turno=new Turno();

        mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador);


        Juego juego=new Juego(jugador,mapa,turno);


        do{
            juego.realizarTurno();              
        }
        while (juego.getResultado()=="En proceso") ; 

        assertEquals(jugador.getCreditos(),81);

    }
    @Test
    public void Prueba02(){
        String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigos12Hormigas.json";
        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Turno turno=new Turno();
                Jugador jugador=new Jugador("Juan Cruz");
        jugador.agregarCreditos(40);

        mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 2, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 3, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 4, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 5, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 6, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 7, "Torre Plateada",jugador);

        Juego juego=new Juego(jugador,mapa,turno);

        do{
            juego.realizarTurno();              
        }
        while (juego.getResultado()=="En proceso") ; 

        assertEquals(jugador.getCreditos(),14);

    }

    @Test
    public void Prueba03(){
        
               String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosAraña.json";
        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Turno turno=new Turno();
                Jugador jugador=new Jugador("Juan Cruz");
        jugador.agregarCreditos(40);

        mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 2, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 3, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 4, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 5, "Torre Plateada",jugador);

        Juego juego=new Juego(jugador,mapa,turno);

        for (int i = 0; i < 25; i++) {
            juego.realizarTurno();   
        }
        //Como probamos lo aleatorio.
        assertTrue(jugador.getCreditos()>0);

    }
}
