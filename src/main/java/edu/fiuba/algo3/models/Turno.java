package edu.fiuba.algo3.models;

public class Turno {
    private int turnoActual;

    public Turno(){
        this.turnoActual=0;
    }

    public int getTurno(){
        return turnoActual;
    }

    public void pasarTurno(){
        turnoActual++;
        var log = Log.obtenetInstancia();
        log.imprimirTurno(turnoActual);
    }

    public boolean esTurnoPar(){
        return (turnoActual%2==0);
    }
}
