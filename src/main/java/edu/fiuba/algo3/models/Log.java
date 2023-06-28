package edu.fiuba.algo3.models;

import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class Log{
    private static Log INSTANCIA = new Log();

    private Log(){}

    public static Log obtenetInstancia(){
        return INSTANCIA;
    }

    public void imprimirResultado(String resultado){
        System.out.println("Jugador "+ resultado +" la Partida");
    }

    public void imprimirDanioEnemigo(Enemigo enemigo){
        System.out.println(enemigo.getNombre()+" llega a la meta, produce "
        +enemigo.getAtaque()+" daño al jugador");
    }

    public void imprimirAtaque(Defensa defensa, Enemigo enemigo, Cordenada coordenada){
        System.out.println(defensa.getNombre()+ " ataca una " + enemigo.getNombre() + 
        " en la posición " + coordenada.getCoordenadas());
    }

    public void imprimirConstruccion(Defensa defensa, Cordenada coordenada){
        System.out.println("Jugador Construye "+defensa.getNombre() + 
        " en posición " + coordenada.getCoordenadas());
    }

    public void imprimirTurno(int turno){
        System.out.println("Turno " + turno);
    }

    public void imprimirAtaqueLechuza(Defensa defensa){
        System.out.println("Lechuza destruye una " + defensa.getNombre() + " en la posición " + 
        defensa.obtenerCordenada().getCoordenadas());
    }
}