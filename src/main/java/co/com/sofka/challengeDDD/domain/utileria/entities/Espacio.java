package co.com.sofka.challengeDDD.domain.utileria.entities;

import co.com.sofka.challengeDDD.domain.utileria.ids.EspacioID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoHabitacion;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoHabitacion;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;


public class Espacio extends Entity<EspacioID> {

    // se crean variables para los objectValue

    private TipoHabitacion tipoHabitacion;
    private EstadoHabitacion estadoHabitacion;

    // se crea constructor para los objectValue

    public Espacio(EspacioID entityId, TipoHabitacion tipoHabitacion, EstadoHabitacion estadoHabitacion) {
        super(entityId);
        this.tipoHabitacion = tipoHabitacion;
        this.estadoHabitacion = estadoHabitacion;
    }

    // métodos de la entidad Espacio

    // cambiarTipoHabitacion()
    public void cambiarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = Objects.requireNonNull(tipoHabitacion);
    }

    // CambiarEstadoHabitacion()
    public void CambiarEstadoHabitacion(EstadoHabitacion estadoHabitacion){
        this.estadoHabitacion = Objects.requireNonNull(estadoHabitacion);
    }
}
