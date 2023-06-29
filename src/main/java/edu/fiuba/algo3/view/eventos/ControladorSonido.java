package edu.fiuba.algo3.view.eventos;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ControladorSonido {
    
    public MediaPlayer setMusicaInicial(){
        MediaPlayer mediaPlayer = this.setMusica(0.2, "/sonidos/intro.mp3");
        this.repetirMusica(mediaPlayer);
        return mediaPlayer;
    }

    public MediaPlayer setMusicPrincipal(){
        MediaPlayer mediaPlayer = this.setMusica(0.1, "/sonidos/principal.mp3");
        this.repetirMusica(mediaPlayer);
        return mediaPlayer;
    }

    public MediaPlayer setMusicGanar(){
        MediaPlayer mediaPlayer = this.setMusica(0.1, "/sonidos/SonidoGanar.mp3")    ;
        return mediaPlayer;
    }
    
    public MediaPlayer setMusicPerder(){
        MediaPlayer mediaPlayer = this.setMusica(0.1, "/sonidos/SonidoPerder.mp3")     ; 
        return mediaPlayer;
    }

     private MediaPlayer setMusica(double volumen, String ruta){
        
        Media media = new Media(getClass().getResource(ruta).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(volumen));
        mediaPlayer.setAutoPlay(true);
        
        return mediaPlayer;
    }

    private void repetirMusica(MediaPlayer mediaPlayer){
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });
    }

    public void silenciar(MediaPlayer mediaPlayer){

        if(mediaPlayer.volumeProperty().get()==0)
            mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0.1));
        else
            mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0));
    }

    public void setMusicaError() {
        Media media = new Media(getClass().getResource("/sonidos/Error.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0.1));
        mediaPlayer.setAutoPlay(true);           
    }
}
