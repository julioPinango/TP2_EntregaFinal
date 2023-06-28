package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.fiuba.algo3.models.Jugador;

public class CasodeUso1 {    
    @Test
    public void Prueba01(){
        Jugador prueba=new Jugador("Juan");
        
        assertEquals(prueba.getCreditos(),100);
        assertEquals(prueba.getVida(),20);
    }
}
