package edu.fiuba.algo3.models.Enemigos.Ataques;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Turno;


public class AtaqueTopo extends Ataque{

    
    Turno _Turno=null;
    int _danio=2;
    
    public AtaqueTopo (Turno turno){
        _Turno=turno;
    }

    public void dañar(Jugador player){

        if(_Turno.esTurnoPar())            
            _danio=_danio+3;

        player.recibirAtaque(_danio);        
    }

    public int getdanio() {
        return _danio;
    }
}

