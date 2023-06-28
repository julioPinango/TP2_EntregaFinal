package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Turno;

public class iniciarJuego {
    private String nombreJugador;

    public iniciarJuego(String nombre){
        this.nombreJugador=nombre;
    }

    public Juego devolverJuego(){
        String path = "src/main/java/edu/fiuba/algo3/models/ArchivosJson/JSONdeEnemigosDefinitivo.json";

        String path2 = "src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";

        Parser parser = new Parser();
        Mapa mapa = new Mapa(path, path2, parser);
        Turno turno = new Turno();
        Jugador jugador = new Jugador(nombreJugador);
        Juego juego = new Juego(jugador, mapa, turno);

        return juego;
    }
}
