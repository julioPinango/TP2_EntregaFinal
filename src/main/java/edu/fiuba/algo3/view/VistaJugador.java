package edu.fiuba.algo3.view;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.BotonPasarTurnoHandler;
import edu.fiuba.algo3.view.eventos.SeleccionDefensaEventHandle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class VistaJugador extends GridPane{
    private Juego juego;
    private VistaMapa vistaMapa;
    private VistaTurno _VistaTurno;
    private Stage stage;
    private MediaPlayer mediaPlayer;

    public VistaJugador(Juego j, VistaMapa vM,VistaTurno vT, Stage s, MediaPlayer mP) {
        this.juego = j;
        this.vistaMapa = vM;
        this._VistaTurno=vT;
        this.stage=s;
        this.mediaPlayer=mP;
    }
    
    public GridPane mostrarDatos(){

        this.getChildren().clear();
        this.setPadding(new Insets(0,10,0,10));
        this.setHgap(0);
        this.setVgap(0);
        this.setStyle("-fx-border-color: black;");

        Image imagen = new Image("file:src/main/img/fondoDefensa.png");
        BackgroundImage imagenFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        this.setBackground(new Background(imagenFondo));

        VBox cuadroInfoJugador = new VBox();
        cuadroInfoJugador.setSpacing(0); 
        cuadroInfoJugador.setPadding(new Insets(20, 25,18,25)); 

        Label estadisticasDelJugador = new Label("ESTADISTICAS");
        estadisticasDelJugador.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        estadisticasDelJugador.setTextFill(Color.WHITE);

        Label labelNombre = new Label("Jugador: "+ juego.obtenerNombreDelJugador()); 
        labelNombre.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
        labelNombre.setTextFill(Color.WHITE);

        Label labelVidaRestante = new Label("Vida: "+ juego.obtenerVidaRestanteDelJugador());
        labelVidaRestante.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
        labelVidaRestante.setTextFill(Color.WHITE);

        Label labelCreditos = new Label("Creditos: "+ juego.obtenerCreditosDelJugador()); 
        labelCreditos.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
        labelCreditos.setTextFill(Color.WHITE);

        cuadroInfoJugador.getChildren().addAll(estadisticasDelJugador,labelNombre,labelVidaRestante,labelCreditos);

        StackPane stackPaneCuadro = new StackPane(cuadroInfoJugador);
        stackPaneCuadro.setTranslateX(0); 
        stackPaneCuadro.setTranslateY(0); 

        VBox cuadroBotones = new VBox();
        cuadroBotones.setSpacing(10);
        cuadroBotones.setPadding(new Insets(12));
        cuadroBotones.setAlignment(Pos.CENTER);

        Button botonPasarTurno = pasarTurno();

        this.listaDefensas();

        cuadroBotones.getChildren().addAll(botonPasarTurno);
        this.add(stackPaneCuadro, 0, 0);
        this.add(cuadroBotones, 0,2);

        return this;
    }

    private Button pasarTurno() {

        Button botonPasarTurno=new Button("Pasar Turno");

        BotonPasarTurnoHandler pasarTurno = new BotonPasarTurnoHandler(juego,vistaMapa,this,_VistaTurno, this.stage, this.mediaPlayer);
        botonPasarTurno.setOnAction(pasarTurno);

        return botonPasarTurno;
    }

    private void listaDefensas(){

        VBox cuadroDefensas = new VBox();
        cuadroDefensas.setSpacing(8);
        cuadroDefensas.setPadding(new Insets(0,5,0,5));
        cuadroDefensas.setAlignment(Pos.CENTER);

        VBox TrampaArenosaBox = new VBox();
        TrampaArenosaBox.setSpacing(0);
        TrampaArenosaBox.setAlignment(Pos.CENTER);

        VBox TorreBlancaBox = new VBox();
        TorreBlancaBox.setSpacing(0);
        TorreBlancaBox.setAlignment(Pos.CENTER);

        VBox TorrePlateadaBox = new VBox();
        TorrePlateadaBox.setSpacing(0);
        TorrePlateadaBox.setAlignment(Pos.CENTER);

        Image imgArenoso = new Image("file:src/main/img/arenoso.png");
        Image imgTorreBlanca = new Image("file:src/main/img/TorreBlanca.png");
        Image imgTorrePlateada = new Image("file:src/main/img/TorrePlateada.png");

        Image imgArenosoDeshabilitado = new Image("file:src/main/img/arenosoDeshabilitada.png");
        Image imgTorreBlancaDeshabilitada = new Image("file:src/main/img/TorreBlancaDeshabilitada.png");
        Image imgTorrePlateadaDeshabilitada= new Image("file:src/main/img/TorrePlateadaDeshabilitada.png");

        ImageView imageViewArena = new ImageView(imgArenoso);
        ImageView imageViewBlanca = new ImageView(imgTorreBlanca);
        ImageView imageViewPlateada = new ImageView(imgTorrePlateada);

         
        if (this.juego.obtenerCreditosDelJugador()<10){
           imageViewBlanca.setImage(imgTorreBlancaDeshabilitada);
            imageViewBlanca.setDisable(true);
        }
        if(this.juego.obtenerCreditosDelJugador()<20){
            imageViewPlateada.setImage(imgTorrePlateadaDeshabilitada);
            imageViewPlateada.setDisable(true);
        }
         if (this.juego.obtenerCreditosDelJugador()<25){
            imageViewArena.setImage(imgArenosoDeshabilitado);
            imageViewArena.setDisable(true);
        }

        Line lineaHorizontal1 = new Line(50, 50, 250, 50);
        lineaHorizontal1.setStroke(Color.WHITE);
        Line lineaHorizontal2 = new Line(50, 50, 250, 50);
        lineaHorizontal2.setStroke(Color.WHITE);
        Line lineaHorizontal3 = new Line(50, 50, 250, 50);
        lineaHorizontal3.setStroke(Color.WHITE);

        SeleccionDefensaEventHandle seleccionArena = new SeleccionDefensaEventHandle(this.vistaMapa, "Trampa Arenosa",this);
        SeleccionDefensaEventHandle seleccionBlanca = new SeleccionDefensaEventHandle(this.vistaMapa, "Torre Blanca", this);
        SeleccionDefensaEventHandle seleccionPlateada = new SeleccionDefensaEventHandle(this.vistaMapa, "Torre Plateada", this);

        imageViewArena.setOnMouseClicked(seleccionArena);
        imageViewBlanca.setOnMouseClicked(seleccionBlanca);
        imageViewPlateada.setOnMouseClicked(seleccionPlateada);
        
        Label pasarela = new Label("Defensas de Pasarela");
        pasarela.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        pasarela.setTextFill(Color.WHITE);

        Label trampaArenosa = new Label("Trampa Arenosa");
        trampaArenosa.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
        trampaArenosa.setTextFill(Color.WHITE);

        Label costoTrampa = new Label("25 creditos");
        costoTrampa.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
        costoTrampa.setTextFill(Color.WHITE);

        Label tierra = new Label("Defensas de Tierra");
        tierra.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        tierra.setTextFill(Color.WHITE);

        Label torrreBlanca = new Label("Torre Blanca");
        torrreBlanca.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
        torrreBlanca.setTextFill(Color.WHITE);

        Label costoBlanca = new Label("10 creditos");
        costoBlanca.setStyle("-fx-font-size: 12px;-fx-font-weight: bold;");
        costoBlanca.setTextFill(Color.WHITE);

        Label torrePlateada = new Label("Torre Plateada");
        torrePlateada.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;");
        torrePlateada.setTextFill(Color.WHITE);

        Label costoPlateada = new Label("20 creditos");
        costoPlateada.setStyle("-fx-font-size: 12px;-fx-font-weight: bold;");
        costoPlateada.setTextFill(Color.WHITE);

        imageViewArena.setFitWidth(100);
        imageViewArena.setFitHeight(100);

        imageViewBlanca.setFitWidth(100);
        imageViewBlanca.setFitHeight(100);

        imageViewPlateada.setFitWidth(100);
        imageViewPlateada.setFitHeight(100);

        TrampaArenosaBox.getChildren().addAll(trampaArenosa,imageViewArena,costoTrampa);
        TorreBlancaBox.getChildren().addAll(torrreBlanca,imageViewBlanca,costoBlanca);
        TorrePlateadaBox.getChildren().addAll(torrePlateada,imageViewPlateada,costoPlateada);

        cuadroDefensas.getChildren().addAll(
            lineaHorizontal1,
            pasarela,
            TrampaArenosaBox,
            lineaHorizontal2,
            tierra,
            TorreBlancaBox,
            TorrePlateadaBox,
            lineaHorizontal3);

        this.add(cuadroDefensas,0,1);
    }
}

