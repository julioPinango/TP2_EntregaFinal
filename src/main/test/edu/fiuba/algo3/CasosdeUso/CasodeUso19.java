package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Turno;

public class CasodeUso19 {    
    @Test
    public void Prueba01(){
        
        String path="src/main/resources/ArchivosJson/JSONdeEnemigosDefinitivo.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Turno turno=new Turno();
        Jugador jugador=new Jugador("Juan Cruz");   


        Juego juego=new Juego(jugador,mapa,turno);

        for (int i = 0; i < 26; i++) {
            juego.realizarTurno();
        }

        
        assertEquals("Pierde",juego.getResultado());        
    }
}
