package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.SolucionInvalidaException;
import edu.fiuba.algo3.modelo.opciones.FactoryOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.validadores.ValidadorOpcionUnica;
import edu.fiuba.algo3.modelo.opciones.FactoryOpcionesComunes;

public class VerdaderoFalso extends TipoDePregunta {

    private static final int PUNTAJE_FAVORABLE = 1;
    private static final int PUNTAJE_DESFAVORABLE = 0;

    public VerdaderoFalso(List<Opcion> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        validador = new ValidadorOpcionUnica();

        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Puntaje evaluarEleccion(Eleccion eleccion){
        return this.evaluarEleccion(eleccion, PUNTAJE_FAVORABLE, PUNTAJE_DESFAVORABLE);
    }

    public static VerdaderoFalso recuperar(JsonArray jsonArraySolucion){
        FactoryOpciones factory = new FactoryOpcionesComunes();
        List<Opcion> opciones = factory.crearOpciones(jsonArraySolucion);
        return new VerdaderoFalso(opciones);
    }

    @Override
    public List<Opcion> recuperarOpciones(JsonArray arrayOpciones){
        FactoryOpciones factory = new FactoryOpcionesComunes();
        return factory.crearOpciones(arrayOpciones);
    }
}
