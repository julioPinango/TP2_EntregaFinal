package edu.fiuba.algo3.models.Enemigos.Ataques;

import edu.fiuba.algo3.models.Jugador;

public class AtaqueAraña extends Ataque{

    public void dañar(Jugador player){
        player.recibirAtaque(2);
    }

    public int getdanio() {
        return 2;
    }
}

