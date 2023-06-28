package edu.fiuba.algo3.models.Enemigos.Ataques;

import java.util.List;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Defensas.Defensa;

public class AtaqueLechuza extends Ataque{

    List <Defensa> _defensas=null;

    public AtaqueLechuza (List<Defensa> defensas){
        _defensas=defensas;
    }

    public void dañar(Jugador jugador){ 
        if(_defensas.size()>0)       
        {
            var torre= _defensas.get(0);
            var log = Log.obtenetInstancia();
            log.imprimirAtaqueLechuza(torre);
            torre.destruir();  
        } 
    }

    public int getdanio() {
        return 0;
    }
}

