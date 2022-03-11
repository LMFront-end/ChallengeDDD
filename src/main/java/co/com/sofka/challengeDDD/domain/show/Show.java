package co.com.sofka.challengeDDD.domain.show;

import co.com.sofka.challengeDDD.domain.show.entities.CanalDeTransmision;
import co.com.sofka.challengeDDD.domain.show.entities.Modelo;
import co.com.sofka.challengeDDD.domain.show.entities.Monitor;
import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;
import co.com.sofka.challengeDDD.domain.show.ids.MonitorId;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDeConfidencialidad;
import co.com.sofka.challengeDDD.generics.Email;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Show extends AggregateEvent<ShowId> {

    /*
    * evento --> pasado
    * comando --> presente
    * */

    // se llaman a las entidades de Show
    // modificador de acceso
    protected ShowId showId;
    protected Modelo modelo;
    protected Monitor monitor;
    protected CanalDeTransmision canalDeTransmision;


    // se crea el constructor
    public Show(ShowId entityId) {
        super(entityId);
        // se llaman los comportamientos del agregado
        appendChange(new showCreado(entityId)).apply();

        subscribe(new ShowChange(this));
    }

    // se crea la función from para show
    // Método que permite reconstruir el estado del agregado a partir de una lista de eventos de dominios
    public static Show from(ShowId showId, List<DomainEvent> events){

        var show = new Show(showId);
        // Evento de dominio, aplica el evento de dominio sobre el show
        //events.forEach(event -> show.applyEvent(event))
        events.forEach(show::applyEvent);

        return show;
    }

    // métodos del agregado

    // asignarModelo()
    public void asignarModelo(ModeloId modeloId, Nombre nombre, Identificacion identificacion, Email email){
        Objects.requireNonNull(modeloId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(identificacion);
        Objects.requireNonNull(email);
        appendChange(new ModeloAsignada(modeloId, nombre, identificacion, email)).apply();
    }

    // cambiarModelo()
    public void cambiarModelo(ModeloId modeloId, Nombre nombre, Identificacion identificacion, Email email){
        Objects.requireNonNull(modeloId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(identificacion);
        Objects.requireNonNull(email);
        appendChange(new ModeloCambiada(modeloId, nombre, identificacion, email)).apply();
    }

    // asignarMonitor()
    public void asignarMonitor(MonitorId monitorId, Nombre nombre, Identificacion identificacion, AcuerdoDeConfidencialidad acuerdoDeConfidencialidad){
        Objects.requireNonNull(monitorId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(identificacion);
        Objects.requireNonNull(acuerdoDeConfidencialidad);
        appendChange(new MonitorAsignado(monitorId, nombre, identificacion, acuerdoDeConfidencialidad)).apply();
    }

    // cambiarMonitor()

    // asignarCanalDeTransmision()

    // cambiarCanalDeTransmision()
}
