package edu.fiuba.algo3.view;

import edu.fiuba.algo3.models.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VistaTurno extends GridPane{

    private Juego _juego;

    public VistaTurno(Juego juego) {     
        _juego=juego;      
    }    

    public GridPane mostrarTurno(){

        this.getChildren().clear();
        
        this.setPadding(new Insets(0));
        this.setHgap(0);
        this.setVgap(0);
        this.setStyle("-fx-background-color: GREY; -fx-border-color: black;");

        VBox cuadroTurno = new VBox();
        cuadroTurno.setSpacing(0); 
        cuadroTurno.setPadding(new Insets(10)); 
        this.setAlignment(Pos.CENTER);

        Label turno = new Label("TURNO ACTUAL: "+_juego.getTurno());
        turno.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;"); 
        turno.setTextFill(Color.WHITE);       

        cuadroTurno.getChildren().addAll(turno);

        StackPane stackPaneCuadro = new StackPane(cuadroTurno);
        stackPaneCuadro.setTranslateX(0); 
        stackPaneCuadro.setTranslateY(0); 

        this.add(stackPaneCuadro, 0, 0);

        return this;
    }


}
