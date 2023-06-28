package edu.fiuba.algo3.models.Enemigos.Ataques;

import edu.fiuba.algo3.models.Jugador;

public class AtaqueHormiga extends Ataque{

    public void dañar(Jugador player){
        player.recibirAtaque(1);
    }
    public int getdanio() { 
        return 1;
    }
}

