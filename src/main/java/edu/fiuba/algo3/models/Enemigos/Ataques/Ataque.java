package edu.fiuba.algo3.models.Enemigos.Ataques;

import java.util.List;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Turno;
import edu.fiuba.algo3.models.Defensas.*;

public abstract class Ataque{

    public void dañar(Jugador player){
        player.recibirAtaque(0);
    }

    public void dañar(Jugador player,Turno turno){
        player.recibirAtaque(0);
    }

    public void dañar(List<Defensa> Defensas)
    {
        
    }

    public int getdanio() {
        return 0;
    }




}

