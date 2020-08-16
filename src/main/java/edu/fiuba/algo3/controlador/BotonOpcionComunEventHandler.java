package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionComun;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class BotonOpcionComunEventHandler implements EventHandler<ActionEvent> {

    private Opcion opcionAsociada;
    private ControladorRespuesta controladorRespuesta;

    public BotonOpcionComunEventHandler(ControladorRespuesta controladorRespuesta,  String opcionAsociada) {
        this.controladorRespuesta = controladorRespuesta;
        this.opcionAsociada = new OpcionComun(opcionAsociada);

    }

    public void handle(ActionEvent actionEvent) {
        controladorRespuesta.agregarOpcion(opcionAsociada);
    }
}