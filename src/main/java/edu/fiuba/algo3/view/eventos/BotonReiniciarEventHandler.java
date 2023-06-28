package edu.fiuba.algo3.view.eventos;


import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class BotonReiniciarEventHandler implements EventHandler<ActionEvent>{
    private Stage stage;
    private Juego juego;

    public BotonReiniciarEventHandler(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego=juego;
    }

    public void handle(ActionEvent actionEvent) {
        iniciarJuego nuevoJuego = new iniciarJuego(juego.obtenerNombreDelJugador());

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, nuevoJuego.devolverJuego());
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(contenedorPrincipal);
        scrollPane.setPrefSize(200, 200);
        

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setVvalue(0.5); // Centrar verticalmente
        scrollPane.setHvalue(0.5); // Centrar horizontalmente

        Scene proximaVentana = new Scene(scrollPane, 1080, 780);

        stage.setScene(proximaVentana);
        stage.centerOnScreen();
    }
}
