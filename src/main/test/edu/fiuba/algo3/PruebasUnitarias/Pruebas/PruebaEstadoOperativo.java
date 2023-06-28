package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Defensas.Estados.EstadoOperativo;

public class PruebaEstadoOperativo {
    
    @Test
    public void TestPuedoAtacar(){
        EstadoOperativo operativo = new EstadoOperativo();

        assertTrue(operativo.puedoAtacar());
    }

    @Test
    public void TestEstaDestruido(){
        EstadoOperativo operativo = new EstadoOperativo();

        assertFalse(operativo.destruido());
    }
}