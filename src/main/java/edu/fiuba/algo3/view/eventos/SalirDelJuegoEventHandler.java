package edu.fiuba.algo3.view.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SalirDelJuegoEventHandler implements EventHandler<ActionEvent>{

    private Stage _Stage;

    public SalirDelJuegoEventHandler(Stage stage){
      _Stage=stage;
    }

    public void handle(ActionEvent mouseEvent){
        _Stage.close();
    }
}
