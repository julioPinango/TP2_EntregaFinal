package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.view.VistaJugador;
import edu.fiuba.algo3.view.VistaMapa;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SeleccionDefensaEventHandle implements EventHandler<MouseEvent>{
    private VistaMapa vistaMapa;
    private String tipoDefensa;
    private VistaJugador vistJugador;

    public SeleccionDefensaEventHandle(VistaMapa mapa, String tipo, VistaJugador vistaJugador){
        this.vistaMapa= mapa;
        this.tipoDefensa=tipo;
        this.vistJugador=vistaJugador;
    }
    
    public void handle(MouseEvent mouseEvent) {
        this.vistaMapa.setVistaJugador(vistJugador);
        this.vistaMapa.setTipoDefensa(tipoDefensa);
        this.vistaMapa.setHabilitacionParcelas(true);

    }
}
