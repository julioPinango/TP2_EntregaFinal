package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Defensas.Estados.EstadoEnConstruccion;

public class PruebaEstadoEnConstruccion {
    
    @Test
    public void TestPuedoAtacar(){
        EstadoEnConstruccion enConstruccion = new EstadoEnConstruccion(0);

        assertTrue(enConstruccion.puedoAtacar());
    }

    @Test
    public void TestNoPuedoAtacar(){
        EstadoEnConstruccion enConstruccion = new EstadoEnConstruccion(2);

        assertFalse(enConstruccion.puedoAtacar());
    }

    @Test
    public void TestEstaDestruido(){
        Random random = new Random();

        // Generar un número entero aleatorio entre 0 y 9
        int numeroAleatorio = random.nextInt(10);
        EstadoEnConstruccion enConstruccion = new EstadoEnConstruccion(numeroAleatorio);

        assertFalse(enConstruccion.destruido());
    }
}