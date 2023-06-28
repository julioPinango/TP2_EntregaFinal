package edu.fiuba.algo3.PruebasUnitarias.Pruebas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Turno;
import edu.fiuba.algo3.models.Enemigos.Lechuza;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoLechuzaenDiagonal;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoLechuzaenL;

import java.io.IOException;

public class PruebaLechuza {    
    @Test
    public void Test01LechuzaVuelaEnFormadeL() throws IOException{
   
        //Pruebo que la lechuza se mueve en forma de L

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json"; 
            String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosLechuza.json";    
            Parser parser=new Parser();       

            Mapa mapa=new Mapa(path2, path, parser);
    
            var list= parser.formarCamino(path);

            var camino=mapa.inicializarCaminoDeEnemigos(list);          
    
            Lechuza lechuza=new Lechuza(camino,new MovimientoLechuzaenL());

            lechuza.mover();                        

            assertEquals(3,lechuza.getCordenada().getX());
            assertEquals(3,lechuza.getCordenada().getY());
    }
    @Test
    public void Test02LechuzaVuelaEnDiagonSiTieneMenosDel50PorcientoDeVida() throws IOException{
   
        //Pruebo que la lechuza se mueve en forma de L

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json"; 
            String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosLechuza.json";    
            Parser parser=new Parser();       

            Mapa mapa=new Mapa(path2, path, parser);
    
            var list= parser.formarCamino(path);

            var camino=mapa.inicializarCaminoDeEnemigos(list);          
    
            Lechuza lechuza=new Lechuza(camino,new MovimientoLechuzaenDiagonal());

            lechuza.recibirAtaque(4);            

            lechuza.mover();                        

            assertEquals(lechuza.getCordenada().getX(),6);
            assertEquals(lechuza.getCordenada().getY(),5);
    }
@Test
    public void Test03LechuzaEliminaUnaTorre() throws IOException{
   
        //Pruebo que la lechuza elimina una torre   

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json"; 
            String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosLechuza.json";    
            Parser parser=new Parser();       

            Mapa mapa=new Mapa(path2, path, parser);
    
            var Jugador=new Jugador("Julianna");

            var turno= new Turno();
    
            var juego=new Juego(Jugador, mapa,turno);

            juego.colocarDefensas(0, 1, "Torre Plateada");   
            
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();   

            assertEquals(0,mapa.getDefensas().size());
    }
    @Test
        public void Test04LechuzaNoHaceDaño() throws IOException{
   
        //Pruebo que la lechuza no hace daño   

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json"; 
            String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosLechuza.json";    
            Parser parser=new Parser();       

            Mapa mapa=new Mapa(path2, path, parser);
    
            var Jugador=new Jugador("Julianna");
    
            var turno= new Turno();
    
            var juego=new Juego(Jugador, mapa,turno);

            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
    
            assertEquals(20,Jugador.getVida());
    }
    @Test
    public void Test05LechuzaNodaCreditos() throws IOException{
   
            //Pruebo que la lechuza no da creditos. 

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json"; 
            String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosLechuza.json";    
            Parser parser=new Parser();       

            Mapa mapa=new Mapa(path2, path, parser);
        
            var Jugador=new Jugador("Julianna");
    
            var turno= new Turno();
    
            var juego=new Juego(Jugador, mapa,turno);

            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();
            juego.realizarTurno();

            assertEquals(100,Jugador.getCreditos());
    }
}
