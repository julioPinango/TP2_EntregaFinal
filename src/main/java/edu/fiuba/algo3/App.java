package edu.fiuba.algo3;

import edu.fiuba.algo3.view.ContenedorInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
    
        stage.setTitle("Tower Defense");

        ContenedorInicial contenedorInicial = new ContenedorInicial(stage);
        Scene scene = new Scene(contenedorInicial ,800,470);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}