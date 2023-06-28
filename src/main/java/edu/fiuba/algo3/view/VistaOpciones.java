package edu.fiuba.algo3.view;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.BotonReiniciarEventHandler;
import edu.fiuba.algo3.view.eventos.OpcionesPantallaCompletaEventHandler;
import edu.fiuba.algo3.view.eventos.OpcionesSilenciarMusicaEventHandler;
import edu.fiuba.algo3.view.eventos.SalirDelJuegoEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class VistaOpciones extends MenuBar{

    private Juego juego;
    private Stage stage;
    private Menu subMenu;
    private MediaPlayer mediaPlayer;

    public VistaOpciones(Stage stage, Juego juego, MediaPlayer mediaPlayer) {     

        this.juego=juego;
        this.stage=stage;
        this.mediaPlayer=mediaPlayer;
        this.subMenu=this.setOpciones();
        this.getMenus().addAll(this.subMenu);
    }    

    private Menu setOpciones(){

        Menu subMenuButton = new Menu("Opciones");
        MenuItem silenciarMusicaItem = new MenuItem("Silenciar música");
        MenuItem silenciarEfectosItem = new MenuItem("Silenciar efectos");
        MenuItem pantallaCompletaItem = new MenuItem("Pantalla completa");
        MenuItem SalirItem = new MenuItem("Salir del Juego");
        MenuItem reiniciarJuego = new MenuItem("Reiniciar Juego");

        OpcionesPantallaCompletaEventHandler clickPantallaCompleta = new OpcionesPantallaCompletaEventHandler(stage);
        pantallaCompletaItem.setOnAction(clickPantallaCompleta);

        SalirDelJuegoEventHandler clickSalir = new SalirDelJuegoEventHandler(stage);
        SalirItem.setOnAction(clickSalir);

        BotonReiniciarEventHandler reiniciarEventHandler = new BotonReiniciarEventHandler(stage,juego);
        reiniciarJuego.setOnAction(reiniciarEventHandler);

        OpcionesSilenciarMusicaEventHandler silenciarMusica= new OpcionesSilenciarMusicaEventHandler(mediaPlayer);
        silenciarMusicaItem.setOnAction(silenciarMusica);

        subMenuButton.getItems().addAll(silenciarMusicaItem, silenciarEfectosItem, pantallaCompletaItem,SalirItem,reiniciarJuego);

        return subMenuButton;
    }
}
