package co.com.sofka.challengeDDD.domain.show.entities;

import co.com.sofka.challengeDDD.domain.show.ids.MonitorId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDeConfidencialidad;
import co.com.sofka.challengeDDD.domain.generics.Identificacion;
import co.com.sofka.challengeDDD.domain.generics.Nombre;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Monitor extends Entity<MonitorId> {

    // se crean variables para los objectValue

    private Nombre nombre;
    private Identificacion identificacion;
    private AcuerdoDeConfidencialidad acuerdoDeConfidencialidad;

    // se crea constructor para los objectValue
    public Monitor(MonitorId monitorId, Nombre nombre, Identificacion identificacion, AcuerdoDeConfidencialidad acuerdoDeConfidencialidad){

        // Super --> Herencia
        super(monitorId);
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.acuerdoDeConfidencialidad = acuerdoDeConfidencialidad;
    }

    // métodos de la entidad Monitor

    // cambiarNombre()
    public void cambiarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    // cambiarIdentificacion()
    public void cambiarIdentificacion(Identificacion identificacion){
        this.identificacion = Objects.requireNonNull(identificacion);
    }

    // cambiarAcuerdoDeConfidencialidad()
    public void cambiarAcuerdoDeConfidencialidad(AcuerdoDeConfidencialidad acuerdoDeConfidencialidad){
        this.acuerdoDeConfidencialidad = Objects.requireNonNull(acuerdoDeConfidencialidad);
    }

}
