package co.com.sofka.challengeDDD.domain.show.entities;

import co.com.sofka.challengeDDD.domain.show.ids.MonitorId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDeConfidencialidad;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Monitor extends Entity<MonitorId> {

    // se crean variables para los ovjectValue

    private Nombre nombre;
    private Identificacion identificacion;
    private AcuerdoDeConfidencialidad acuerdoDeConfidencialidad;

    // se crea constructor para los objectValue
    public Monitor(MonitorId monitorId, Nombre nombre, Identificacion identificacion, AcuerdoDeConfidencialidad acuerdoDeConfidencialidad){

        // Super --> Herencia
        super(monitorId);
    }
}
