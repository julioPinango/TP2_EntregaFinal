package edu.fiuba.algo3.view;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.BotonReiniciarEventHandler;
import edu.fiuba.algo3.view.eventos.SalirDelJuegoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorFinal extends VBox{

    private Juego juego;
    private Stage stage;

    public ContenedorFinal(Stage s, Juego j) {
        this.juego=j;
        this.stage=s;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image imagen = new Image("file:src/main/img/final.jpg");
        BackgroundImage imagenFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        this.setBackground(new Background(imagenFondo));

        this.setResultado();
        this.setBotones();
    }

    private void setResultado(){
        Label resultadoJuego = new Label();
        resultadoJuego.setFont(new Font("Trebuchet MS", 25));
        resultadoJuego.setStyle("-fx-font-weight: bold;-fx-background-color: white;");

        if (juego.getResultado()=="Gana")
            resultadoJuego.setText("Felicidades! Ganaste el juego");
        else
            resultadoJuego.setText("Perdiste el juego, será para la próxima!");

        this.getChildren().addAll(
                resultadoJuego
        );
    }
    private void setBotones(){

        HBox contenedor = new HBox();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);
        Button buttonCerrarJuego = new Button("Cerrar juego");
        buttonCerrarJuego.setFont(new Font("Trebuchet MS", 18));
        
        Button buttonReiniciar = new Button("Volver a jugar");
        buttonReiniciar.setFont(new Font("Trebuchet MS", 18));
    
        SalirDelJuegoEventHandler iniciarEventHandler = new SalirDelJuegoEventHandler(stage);
        buttonCerrarJuego.setOnAction(iniciarEventHandler);

        BotonReiniciarEventHandler reiniciarEventHandler = new BotonReiniciarEventHandler(stage,juego);
        buttonReiniciar.setOnAction(reiniciarEventHandler);

        contenedor.getChildren().addAll(
                buttonCerrarJuego,
                buttonReiniciar
        );
        this.getChildren().addAll(contenedor);
    }
}
