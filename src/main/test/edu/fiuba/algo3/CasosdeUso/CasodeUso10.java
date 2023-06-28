package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Turno;

public class CasodeUso10 { 
    
    @Test
    public void Prueba01(){
        
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
        mapa.colocarDefensaEnEstaPosicion(0, 6, "Torre Plateada",jugador);
        mapa.colocarDefensaEnEstaPosicion(0, 7, "Torre Plateada",jugador);

        Juego juego=new Juego(jugador,mapa,turno);

        do{
            juego.realizarTurno();              
        }
        while (juego.getResultado()=="En proceso") ; 

        //Como probamos lo aleatorio.
        assertEquals(juego.getResultado(),"Gana");
    }
}
