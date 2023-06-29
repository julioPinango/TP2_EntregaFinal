package edu.fiuba.algo3.view.eventos;


import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.VistaExcepcion;
import edu.fiuba.algo3.view.VistaMapa;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CrearDefensaEventHandler implements EventHandler<MouseEvent>{
    private VistaMapa vistaMapa;
    private Juego juego;
    private int X;
    private int Y;
    private String tipoDefensa;
    private Stage _stage;

    public CrearDefensaEventHandler(VistaMapa mapa,Juego j,int x,int y, String tipo,Stage s){
        this.vistaMapa= mapa;
        this.juego=j;
        this.X=x;
        this.Y=y;
        this.tipoDefensa= tipo;
        this._stage=s;
    }
    
    public void handle(MouseEvent mouseEvent) {
        if(this.juego.colocarDefensas(X, Y, tipoDefensa)){
            this.vistaMapa.setHabilitacionParcelas(false);
        }
        else
        {           
            String mensaje="";
            String path="";

            if(tipoDefensa=="Trampa Arenosa")
            {        
                mensaje="Recuerde que las trampas arenosas solo se puede construir en las pasarelas";
                path="file:src/main/resources/img/Arenoso.png";
            }               
            else if(tipoDefensa=="Torre Plateada")
            {
                mensaje="Recuerde que las torres plateadas solo se puede construir en las parcelas de tierra y si no hay otra torre en ese lugar";
                path="file:src/main/resources/img/TorrePlateada.png";
            }
            else if(tipoDefensa=="Torre Blanca")
            {
                mensaje="Recuerde que las torres blancas solo se puede construir en las parcelas de tierra y si no hay otra torre en ese lugar";
                path="file:src/main/resources/img/TorreBlanca.png";                
            }           
            
            VistaExcepcion.Alerta(mensaje,path);
        }
    }
}
