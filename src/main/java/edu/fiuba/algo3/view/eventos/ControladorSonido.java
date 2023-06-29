package edu.fiuba.algo3.view.eventos;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ControladorSonido {
    
    public MediaPlayer setMusicaInicial(){
        Media media = new Media(getClass().getResource("/sonidos/intro.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0.2));
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });
        return mediaPlayer;
    }

    public MediaPlayer setMusicPrincipal(){
        Media media = new Media(getClass().getResource("/sonidos/principal.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0.1));
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });
        return mediaPlayer;
    }
    public MediaPlayer setMusicGanar(){
        Media media = new Media(getClass().getResource("/sonidos/SonidoGanar.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0.1));
        mediaPlayer.setAutoPlay(true);        
        return mediaPlayer;
    }
    public MediaPlayer setMusicPerder(){
        Media media = new Media(getClass().getResource("/sonidos/SonidoPerder.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0.1));
        mediaPlayer.setAutoPlay(true);        
        return mediaPlayer;
    }

    public void silenciar(MediaPlayer mediaPlayer){

        if(mediaPlayer.volumeProperty().get()==0)
            mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0.1));
        else
            mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0));
    }
}
