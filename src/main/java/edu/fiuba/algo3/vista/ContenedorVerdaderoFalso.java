package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonOpcionUnicaEventHandler;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.List;
import javafx.scene.text.Font;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class ContenedorVerdaderoFalso extends VBox{

    private static final int ESPACIADO_BOTONES = 15;
    private static final String VERDADERO = "Verdadero";
    private static final String FALSO = "Falso";
    private static final String PATH_IMAGENES_BOTONES = "resources/BotonVerdaderoFalso/";
    private static final String NOMBRE_IMAGENES_PRIMERA_PARTE = "IMG_BOTON_VF_";
    private static final String EXTENSION_IMAGENES = ".png";
    private static final int ANCHO_BOTON_OPCION = 270;
    private static final int ALTO_BOTON_OPCION = 40;

    public ContenedorVerdaderoFalso(ControladorRespuesta controlador){
        super();
        Button botonVerdadero = new Button();
        botonVerdadero.setText(VERDADERO);
        botonVerdadero.setPrefSize(ANCHO_BOTON_OPCION, ALTO_BOTON_OPCION);
        botonVerdadero.setFont(new Font(App.FUENTE, 20));
        botonVerdadero.setOnAction(new BotonOpcionUnicaEventHandler(controlador, VERDADERO));
        try {
            FileInputStream input1 = new FileInputStream(PATH_IMAGENES_BOTONES + NOMBRE_IMAGENES_PRIMERA_PARTE + "1" + EXTENSION_IMAGENES);
            Image  imagenBoton1 = new Image(input1);
            ImageView imageView1 = new ImageView(imagenBoton1);
            botonVerdadero.setGraphic(imageView1);
        }catch(IOException ex){
        }

        Button botonFalso = new Button();
        botonFalso.setText(FALSO);
        botonFalso.setPrefSize(ANCHO_BOTON_OPCION, ALTO_BOTON_OPCION);
        botonFalso.setFont(new Font(App.FUENTE, 20));
        botonFalso.setOnAction(new BotonOpcionUnicaEventHandler(controlador, FALSO));
        try {
            FileInputStream input2 = new FileInputStream(PATH_IMAGENES_BOTONES + NOMBRE_IMAGENES_PRIMERA_PARTE + "2" + EXTENSION_IMAGENES);
            Image imagenBoton2 = new Image(input2);
            ImageView imageView2 = new ImageView(imagenBoton2);
            botonFalso.setGraphic(imageView2);
        }catch(IOException ex){
        }
        this.getChildren().addAll(botonVerdadero, botonFalso);
        this.setSpacing(ESPACIADO_BOTONES);
    }
}