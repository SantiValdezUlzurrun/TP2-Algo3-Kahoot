package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalsoConPenalidad extends TipoDePregunta{

    public VerdaderoFalsoConPenalidad(List<String> solucion){
        Eleccion eleccion = new Eleccion(solucion);
        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    public VerdaderoFalsoConPenalidad(Eleccion eleccion){
        if(!eleccion.esUnaEleccionValidaComoSolucion(this)){
            throw new SolucionInvalidaException();
        }
        eleccionCorrecta = eleccion;
    }

    @Override
    public Certificado evaluarEleccion(Eleccion eleccion){
        if(eleccion.igualA(this.eleccionCorrecta)){
            Certificado correcta = new Correcta(1);
            return correcta;
        }
        Certificado incorrecta = new Incorrecta(1);
        return incorrecta;
    }

    @Override
    public Boolean sonOpcionesValidasComoSolucion(List<String> opciones){
        return (opciones.size() == 1);
    }


    @Override
    public void mostrar(){}
}
