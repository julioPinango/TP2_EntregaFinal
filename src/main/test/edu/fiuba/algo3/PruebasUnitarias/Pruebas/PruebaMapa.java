package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Turno;



public class PruebaMapa {
    
    @Test
    public void TestColocarDefensaEnEstaPosicionCasoPositivo()
    {
            
        String path="src/main/resources/ArchivosJson/enemigosAraña.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Jugador jugador=mock(Jugador.class);
        when(jugador.creditosSuficientes(anyInt())).thenReturn(true);

        assertTrue(mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador));
    }

    @Test
    public void TestColocarDefensaEnEstaPosicionCasoNegativo()
    {
            
        String path="src/main/resources/ArchivosJson/enemigosAraña.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Jugador jugador=mock(Jugador.class);
        when(jugador.creditosSuficientes(anyInt())).thenReturn(true);
        mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador);

        assertFalse(mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador));

    }

    @Test
    public void TestColocarDefensaEnEstaPosicionFueraDelMapa()
    {
            
        String path="src/main/resources/ArchivosJson/enemigosAraña.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Jugador jugador=mock(Jugador.class);


        when(jugador.creditosSuficientes(anyInt())).thenReturn(true);
        mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador);

        assertFalse(mapa.colocarDefensaEnEstaPosicion(-1, 1, "Torre Plateada",jugador));

    }

    @Test
    public void TestTamañoParcelasCorrecto()
    {
            
        String path="src/main/resources/ArchivosJson/enemigosAraña.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Jugador jugador=mock(Jugador.class);



        assertTrue(mapa.getTamañoParcelas()==15);

    }

    @Test
    public void TestHayDefensaEnestaPosicion()
    {
            
        String path="src/main/resources/ArchivosJson/enemigosAraña.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Jugador jugador=mock(Jugador.class);


        when(jugador.creditosSuficientes(anyInt())).thenReturn(true);
        mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador);

        

        assertTrue(mapa.hayDefensaEnEstaPosicion(0, 1));

    }
    @Test
    public void TestNoHayDefensaEnestaPosicion()
    {
            
        String path="src/main/resources/ArchivosJson/enemigosAraña.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Jugador jugador=mock(Jugador.class);        

        assertFalse(mapa.hayDefensaEnEstaPosicion(0, 1));

    }

    @Test
    public void TestObtenerTipoDefensa()
    {
            
        String path="src/main/resources/ArchivosJson/enemigosAraña.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Jugador jugador=mock(Jugador.class);        

        when(jugador.creditosSuficientes(anyInt())).thenReturn(true);

        mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador);

        assertEquals(mapa.obtenerTipoDefensa(0, 1),"Torre Plateada");

    }

    @Test
    public void TestObtenerTipoParcela()
    {
            
        String path="src/main/resources/ArchivosJson/enemigosAraña.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Jugador jugador=mock(Jugador.class);        

        assertEquals(mapa.obtenerTipoParcela(0, 1),"Tierra");

    }

    @Test
    public void TestDefensaEnConstruccion()
    {
            
        String path="src/main/resources/ArchivosJson/enemigosAraña.json";
        String path2="src/main/resources/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Jugador jugador=mock(Jugador.class);        

        when(jugador.creditosSuficientes(anyInt())).thenReturn(true);

        mapa.colocarDefensaEnEstaPosicion(0, 1, "Torre Plateada",jugador);

        assertTrue(mapa.defensaEnConstruccion(0, 1)==true);

    }
}