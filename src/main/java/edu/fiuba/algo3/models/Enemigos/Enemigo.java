package edu.fiuba.algo3.models.Enemigos;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Enemigos.Ataques.Ataque;
import edu.fiuba.algo3.models.Enemigos.Movimientos.Movimiento;

public abstract class Enemigo{

    protected int Velocidad ;
    protected Ataque ataque ;
    protected int Energia ;
    protected String nombre;
    protected boolean ralentizado;
    protected Movimiento movimiento;
    protected boolean llegoAlFinal=false;

    protected Queue<Pasarela> pasarelas = new LinkedList<>();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Enemigo otra = (Enemigo) obj;
        return Objects.equals(Velocidad, otra.Velocidad) &&
               Objects.equals(ataque, otra.ataque)&&
               Objects.equals(Energia, otra.Energia)&&
               Objects.equals(nombre, otra.nombre);
    }

    public int getAtaque() {
        return ataque.getdanio();
    }
    public int getEnergia() {
        return Energia;
    }
    public String getNombre(){
        return nombre;
    }
    public Cordenada getCordenada() {
        return pasarelas.peek().getCordenada();
    }

    public void definirAtaque(Ataque ataque)
    {
        this.ataque=ataque;
    }

    public boolean recibirAtaque(int danio) {
        Energia=Energia-danio;
        return true;
    }

    public void mover() {
          
    }
    public void sumarEnemigoMuerto(Jugador jugador) {
    }

    public void otorgarCreditos(Jugador jugador)
    {
        jugador.agregarCreditos(0);
    }

    public void atacarJugador(Jugador jugador){
        var log = Log.obtenetInstancia();
        log.imprimirDanioEnemigo(this);
        this.ataque.dañar(jugador);
    }

    public void ralentizar() {
        this.ralentizado=true;
    }

    public boolean llegoAlFinal() {
        return llegoAlFinal;
    }

  
}