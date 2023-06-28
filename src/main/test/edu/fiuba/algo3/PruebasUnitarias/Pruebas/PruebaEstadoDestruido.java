package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Defensas.Estados.EstadoDestruido;

public class PruebaEstadoDestruido {
    
    @Test
    public void TestPuedoAtacar(){
        EstadoDestruido destruido = new EstadoDestruido();

        assertFalse(destruido.puedoAtacar());
    }

    @Test
    public void TestEstaDestruido(){
        EstadoDestruido destruido = new EstadoDestruido();

        assertTrue(destruido.destruido());
    }
}
