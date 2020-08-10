package edu.fiuba.algo3.modelo;

import java.util.List;

public class ExclusividadInactiva implements EstadoExclusividad{

    private int factor;

    public ExclusividadInactiva(){
        this.factor = 1;
    }

    @Override
    public void aplicar(List<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarPuntaje();
        }
    }

    @Override
    public EstadoExclusividad upgrade(){
        return new ExclusividadActiva(this.factor*2);
    }
}
