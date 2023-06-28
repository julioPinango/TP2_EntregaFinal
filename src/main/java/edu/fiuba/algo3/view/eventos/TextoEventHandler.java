package edu.fiuba.algo3.view.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoEventHandler implements EventHandler<KeyEvent> {

    private EventHandler evento;
    private TextField nombreJugador;

    public TextoEventHandler(EventHandler eventHandler, TextField nombre){
        this.evento = eventHandler;
        this.nombreJugador=nombre;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        var nombre=nombreJugador.getText();
        if((keyEvent.getCode() == KeyCode.ENTER)){
            if (nombre.length()>5){
                evento.handle(new ActionEvent());
            }
        }
    }
}

