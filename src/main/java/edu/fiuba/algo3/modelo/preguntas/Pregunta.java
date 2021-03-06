package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.respuestas.Respuestas;

public class Pregunta {

    private TipoDePregunta tipo;
    private String enunciado;
    private List<Opcion> opciones;

    public Pregunta(String enunciado, List<Opcion> opciones, TipoDePregunta tipo){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.tipo = tipo;
    }

    public void responderPregunta(Respuestas respuestas) {
        respuestas.responder(tipo);
    }

    public TipoDePregunta getTipoDePregunta(){
        return tipo;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public static Pregunta recuperar(JsonObject jsonObjectPregunta){

        String enunciado = jsonObjectPregunta.get("enunciado").getAsString();
        String tipoDePregunta = jsonObjectPregunta.get("tipo").getAsString();

        FactoryTipoDePregunta factoryTipoDePregunta = new FactoryTipoDePregunta();
        TipoDePregunta tipo = factoryTipoDePregunta.crearTipoDePregunta(tipoDePregunta, jsonObjectPregunta);

        JsonArray arrayOpciones = jsonObjectPregunta.getAsJsonArray("opciones");

        List<Opcion> opciones = tipo.recuperarOpciones(arrayOpciones);
        return new Pregunta(enunciado, opciones, tipo);
    }
}
