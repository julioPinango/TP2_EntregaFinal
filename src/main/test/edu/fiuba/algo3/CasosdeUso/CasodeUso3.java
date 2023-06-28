package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.DefensaFactory;

public class CasodeUso3 {    
    @Test
    public void Prueba01(){
  
        Jugador jugador=new Jugador("Julio Piñango");

        Cordenada cordena=new Cordenada(2,1);

        Defensa torre=DefensaFactory.obtenerDefensa(cordena,"Torre Plateada");

        assertTrue(jugador.creditosSuficientes(torre.getCosto()));
    }
    @Test
    public void Prueba02(){
  
        Jugador jugador=new Jugador("Julio Piñango");
        Cordenada cordena=new Cordenada(2,1);

        Defensa torre=DefensaFactory.obtenerDefensa(cordena,"Torre Blanca");

        jugador.descontarCredito(100);

        assertFalse(jugador.creditosSuficientes(torre.getCosto()));
    }
    @Test
    public void Prueba03(){
  
        Jugador jugador=new Jugador("Julio Piñango");
        Cordenada cordena=new Cordenada(2,1);

        Defensa torre=DefensaFactory.obtenerDefensa(cordena,"Torre Blanca");

        jugador.descontarCredito(90);

        assertTrue(jugador.creditosSuficientes(torre.getCosto()));
    }
}
