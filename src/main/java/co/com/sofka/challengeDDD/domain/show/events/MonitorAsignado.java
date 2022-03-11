package co.com.sofka.challengeDDD.domain.show.events;

import co.com.sofka.challengeDDD.domain.show.ids.MonitorId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDeConfidencialidad;
import co.com.sofka.challengeDDD.domain.generics.Identificacion;
import co.com.sofka.challengeDDD.domain.generics.Nombre;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter
public class MonitorAsignado extends DomainEvent {

    private final MonitorId monitorId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final AcuerdoDeConfidencialidad acuerdoDeConfidencialidad;

    public MonitorAsignado(MonitorId monitorId, Nombre nombre, Identificacion identificacion, AcuerdoDeConfidencialidad acuerdoDeConfidencialidad) {
        super("co.com.sofka.challengeDDD.MonitorAsignado");
        this.monitorId = monitorId;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.acuerdoDeConfidencialidad = acuerdoDeConfidencialidad;
    }
}
