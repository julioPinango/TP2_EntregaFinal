package edu.fiuba.algo3.view;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import edu.fiuba.algo3.view.eventos.ControladorSonido;
import javafx.scene.control.Alert;

public class VistaExcepcion extends VBox {



    public static void Alerta(String mensaje,String path)
    {
        Alert alert=new Alert(AlertType.ERROR);
        alert.setTitle("Error");
		alert.setContentText(mensaje);


        // Obtener el DialogPane de la alerta
        DialogPane dialogPane = alert.getDialogPane();

        // Crear una ImageView con la nueva imagen
        Image image = new Image(path);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(48); // Ajusta el ancho de la imagen (opcional)
        imageView.setFitHeight(48); // Ajusta el alto de la imagen (opcional)

        // Establecer la imagen personalizada en el DialogPane
        dialogPane.setGraphic(imageView);

        ControladorSonido controlador =new ControladorSonido();
        controlador.setMusicaError();
        
		alert.showAndWait();
    }
}