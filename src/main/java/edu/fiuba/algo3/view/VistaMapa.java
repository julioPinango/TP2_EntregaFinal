package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.CrearDefensaEventHandler;
import edu.fiuba.algo3.view.eventos.MouseFueraParcelasEventHandler;
import edu.fiuba.algo3.view.eventos.MouseParcelasEventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class VistaMapa extends GridPane{
    private Juego juego;
    private Boolean parcelasHabilitadas;
    private String tipoDefensa;
    private VistaJugador vistaJugador;
    private Map<String, Image> imagenes = new HashMap<>();

    public VistaMapa(Juego j) {
        this.juego = j;
        this.parcelasHabilitadas=false;
        imagenes=setearImagenes();
    }

    private Map<String, Image> setearImagenes() {
        
        Image imagenTierra = new Image("file:src/main/img/tierra.jpg");
        Image imagenRocoso = new Image("file:src/main/img/rocoso.png");
        Image imagenPasarela = new Image("file:src/main/img/pasarela.png");

        Image imgArenoso = new Image("file:src/main/img/arenoso.png");
        Image imgTorreBlanca = new Image("file:src/main/img/TorreBlanca.png");
        Image imgTorrePlateada = new Image("file:src/main/img/TorrePlateada.png");
        
        Image imgArenosoEnConstruccion = new Image("file:src/main/img/arenosoEnConstruccion.png");
        Image imgTorreBlancaEnConstruccion = new Image("file:src/main/img/TorreBlancaEnConstruccion.png");
        Image imgTorrePlateadaEnConstruccion = new Image("file:src/main/img/TorrePlateadaEnConstruccion.png");

        Image imagenHormiga = new Image("file:src/main/img/hormiga.png");
        Image imagenAraña = new Image("file:src/main/img/arana.png");
        Image imagenTopo = new Image("file:src/main/img/topo.png");
        Image imagenLechuza = new Image("file:src/main/img/lechuza.png");


        Map<String, Image> imagenes = new HashMap<>();
        imagenes.put("Tierra", imagenTierra);
        imagenes.put("Rocoso", imagenRocoso);
        imagenes.put("Pasarela", imagenPasarela);
        imagenes.put("Trampa Arenosa", imgArenoso);
        imagenes.put("Torre Blanca", imgTorreBlanca);
        imagenes.put("Torre Plateada", imgTorrePlateada);
        imagenes.put("Trampa Arenosa En Construccion", imgArenosoEnConstruccion);
        imagenes.put("Torre Blanca En Construccion", imgTorreBlancaEnConstruccion);
        imagenes.put("Torre Plateada En Construccion", imgTorrePlateadaEnConstruccion);
        imagenes.put("Hormiga", imagenHormiga);
        imagenes.put("Araña", imagenAraña);
        imagenes.put("Topo", imagenTopo);
        imagenes.put("Lechuza", imagenLechuza);

        return imagenes;
    }

    public GridPane mostrarMapa(){

        this.getChildren().clear();     
        this.setPadding(new Insets(0));
        this.setHgap(0);
        this.setVgap(0);

        cargarMapa();

        cargarEnemigos();

        return this;
    }


    private void cargarMapa() {

        int tamañoMapa = juego.getTamañoParcelas();
        
        Image marco=new Image("file:src/main/img/marco.png");
        
        for (int fila = 0; fila < tamañoMapa; fila++) {
            for (int columna = 0; columna < tamañoMapa; columna++) {

                CrearDefensaEventHandler crearDefensa= new CrearDefensaEventHandler(this, juego, fila, columna, tipoDefensa);
            
                ImageView parcela=dibujarParcela(fila,columna);                 

                ImageView imageViewMarco=dibujarMarco(marco); 

                StackPane stackPane = new StackPane();

                stackPane.getChildren().addAll(parcela, imageViewMarco);

                stackPane=dibujarEnemigo(fila,columna,stackPane);

                stackPane.setDisable(!parcelasHabilitadas);
                stackPane.setOnMouseClicked(crearDefensa);
                movimientoMouse(imageViewMarco, stackPane);

                this.add(stackPane, fila, columna);
            }
        }
    }

    private StackPane dibujarEnemigo(int fila, int columna,StackPane stackPane) {
        
        List<String> enemigos=this.juego.enemigosEnPosicion(fila,columna);
        GridPane gridPane = new GridPane();
        gridPane.getChildren().clear();     
        gridPane.setPadding(new Insets(0));

        for (var i=0; i<enemigos.size();i++ ) {
            ImageView enemigo=new ImageView(imagenes.get(enemigos.get(i)));
            enemigo.setFitHeight(16);
            enemigo.setFitWidth(16);
            
            if (i<3){
                gridPane.add(enemigo, i, 0);
            }else if (i<6){
                gridPane.add(enemigo, i-3, 1);
            }else{
                gridPane.add(enemigo, i-6,2);
            }
        }
        stackPane.getChildren().add(gridPane);

        return stackPane;
    }

    private ImageView dibujarParcela(int fila,int columna) {

        String tipo = this.juego.obtenerParcela(fila, columna);

        Image imagen=imagenes.get(tipo);

        if (juego.hayDefensa(fila, columna)){
            if(juego.torreEnConstruccion(fila,columna))                    
                imagen = imagenes.get(juego.devolverDefensa(fila, columna)+" En Construccion");                    
            else                    
                imagen = imagenes.get(juego.devolverDefensa(fila, columna));
        }

        ImageView iv=new ImageView(imagen);

        iv.setFitWidth(51);
        iv.setFitHeight(51);

        return iv;
    }

    private ImageView dibujarMarco(Image imagenMarco) {   
        
        ImageView marco=new ImageView(imagenMarco);
        marco.setFitWidth(51);
        marco.setFitHeight(51);
        marco.setVisible(false);
        return marco;
    }

    private void cargarEnemigos() {

    }

    private void movimientoMouse(ImageView imagen, StackPane stackPane){
        MouseParcelasEventHandler mouseEnParcelas = new MouseParcelasEventHandler(imagen);
        stackPane.setOnMouseEntered(mouseEnParcelas);

        MouseFueraParcelasEventHandler mouseFueraParcelas = new MouseFueraParcelasEventHandler(imagen);
        stackPane.setOnMouseExited(mouseFueraParcelas);
    }

    public void setHabilitacionParcelas(boolean bolean){
        this.parcelasHabilitadas=bolean;
        this.mostrarMapa();
        this.vistaJugador.mostrarDatos();
    }

    public void setVistaJugador(VistaJugador vistJugador){
        this.vistaJugador=vistJugador;
    }

    public void setTipoDefensa(String tipo){
        this.tipoDefensa=tipo;
    }
}

