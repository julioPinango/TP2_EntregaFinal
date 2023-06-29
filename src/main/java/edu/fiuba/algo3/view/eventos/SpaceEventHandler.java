package edu.fiuba.algo3.view.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SpaceEventHandler implements EventHandler<KeyEvent> {

    private BotonPasarTurnoHandler evento;

    public SpaceEventHandler(BotonPasarTurnoHandler eventHandler){
        this.evento = eventHandler;
        }

    @Override
    public void handle(KeyEvent keyEvent) {
        if((keyEvent.getCode() == KeyCode.P)){
                evento.handle(new ActionEvent());            
        }
    }
}

