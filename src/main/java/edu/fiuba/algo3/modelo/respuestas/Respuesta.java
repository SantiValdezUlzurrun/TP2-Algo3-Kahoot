package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.preguntas.Evaluador;

public class Respuesta {

    private static final int PUNTAJE_POR_DEFECTO = 0;
    private Jugador jugador;
    private Eleccion eleccion;
    private Bonificador bonificador;
    private Puntaje puntaje;

    public Respuesta(Jugador jugador, Eleccion eleccion, Bonificador bonificador) {

        this.eleccion = eleccion;
        this.jugador = jugador;
        this.bonificador = bonificador;
        this.puntaje = Puntaje.crearPuntajeFavorable(PUNTAJE_POR_DEFECTO);
    }

    public void responderSegunEvaluador(Evaluador evaluador){
        this.puntaje = evaluador.evaluarEleccion(eleccion);
    }

    public void actualizarPuntaje(){
        jugador.responder(puntaje, bonificador);
    }

    public void cambiarBonificador(Bonificador bonificador){
        this.bonificador = bonificador;
    }

    public boolean respuestaCorrecta(Evaluador evaluador){
        return evaluador.esCorrecta(eleccion);
    }
}