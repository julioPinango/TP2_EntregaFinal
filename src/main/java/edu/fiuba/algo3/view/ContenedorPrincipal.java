package edu.fiuba.algo3.view;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.ControladorSonido;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
    private VistaMapa vistaMapa;
    private Juego juego;
    private Stage stage;
    private HBox contenedor;
    private MediaPlayer mediaPlayer;

    public ContenedorPrincipal(Stage s, Juego j){
        this.stage=s;
        this.juego=j;
        this.setMusica();

        Image imagen = new Image("file:src/main/img/difuminado.png");
        BackgroundImage imagenFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        this.setBackground(new Background(imagenFondo));

        this.setMenu();
        this.vistaMapa=this.setMapa();
        this.setOpcionesJugador();
        this.setCenter(contenedor);
        contenedor.setAlignment(Pos.CENTER);
    }

    private void setMenu(){
        VistaOpciones opcionesMenu = new VistaOpciones(stage, juego, mediaPlayer);
        this.setTop(opcionesMenu);
    }

    private VistaMapa setMapa(){
        VistaMapa vista= new VistaMapa(juego);
        this.contenedor= new HBox();
        contenedor.getChildren().addAll(vista.mostrarMapa());
        vista.setAlignment(Pos.CENTER);
        return vista;
    }

    private void setOpcionesJugador(){
        VBox ContenedorMenu=new VBox();
        VistaTurno turno=new VistaTurno(juego);
        VistaJugador vistaJugador = new VistaJugador(juego, vistaMapa,turno,stage, mediaPlayer);
        ContenedorMenu.getChildren().addAll(vistaJugador.mostrarDatos(),turno.mostrarTurno());
        ContenedorMenu.setAlignment(Pos.CENTER);
        contenedor.getChildren().addAll(ContenedorMenu);
    }

    private void setMusica(){
        ControladorSonido controladorSonido= new ControladorSonido();
        this.mediaPlayer=controladorSonido.setMusicPrincipal();
    }
}
