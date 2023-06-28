package edu.fiuba.algo3.view.eventos;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MouseFueraParcelasEventHandler implements EventHandler<MouseEvent>{
    private ImageView img;

    public MouseFueraParcelasEventHandler(ImageView imagen){
        this.img=imagen;
    }

     public void handle(MouseEvent mouseEvent){
         this.img.setVisible(false);
    }
}
