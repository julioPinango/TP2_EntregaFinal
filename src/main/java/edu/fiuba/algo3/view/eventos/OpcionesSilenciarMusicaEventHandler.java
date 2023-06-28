package edu.fiuba.algo3.view.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;

public class OpcionesSilenciarMusicaEventHandler implements EventHandler<ActionEvent>{

    private MediaPlayer mediaPlayer;

    public OpcionesSilenciarMusicaEventHandler(MediaPlayer mediaPlayer){
        this.mediaPlayer=mediaPlayer;
    }

    public void handle(ActionEvent mouseEvent){
        ControladorSonido controlador =new ControladorSonido();
        controlador.silenciar(mediaPlayer);
    }
}