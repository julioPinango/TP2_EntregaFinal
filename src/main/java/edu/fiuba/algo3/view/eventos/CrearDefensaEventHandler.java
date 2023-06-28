package edu.fiuba.algo3.view.eventos;


import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.VistaMapa;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CrearDefensaEventHandler implements EventHandler<MouseEvent>{
    private VistaMapa vistaMapa;
    private Juego juego;
    private int X;
    private int Y;
    private String tipoDefensa;

    public CrearDefensaEventHandler(VistaMapa mapa,Juego j,int x,int y, String tipo){
        this.vistaMapa= mapa;
        this.juego=j;
        this.X=x;
        this.Y=y;
        this.tipoDefensa= tipo;
    }
    
    public void handle(MouseEvent mouseEvent) {
        if(this.juego.colocarDefensas(X, Y, tipoDefensa)){
            this.vistaMapa.setHabilitacionParcelas(false);
        }
    }
}
