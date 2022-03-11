package co.com.sofka.challengeDDD.domain.utileria;

import co.com.sofka.challengeDDD.domain.utileria.entities.Espacio;
import co.com.sofka.challengeDDD.domain.utileria.entities.InsumoElectronico;
import co.com.sofka.challengeDDD.domain.utileria.entities.Producto;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Utileria extends AggregateEvent<UtileriaID> {

    /*
     * evento --> pasado
     * comando --> presente
     * */

    // se llama a las entidades de Utileria

    protected UtileriaID utileriaID;
    protected Espacio espacio;
    protected InsumoElectronico insumoElectronico;
    protected Producto producto;


    // se crea el constructor
    public Utileria(UtileriaID entityId) {
        super(entityId);
        // se llama a los comportamientos del agregado
        appendChange(new UtileriaCreada(entityId)).apply();

        subscribe(new UtileriaChange(this));
    }

    // se crea la función from para show
    // Método que permite reconstruir el estado del agregado a partir de una lista de eventos de dominios
    public static Utileria from(UtileriaID utileriaID, List<DomainEvent> events){

        var utileria = new Utileria(utileriaID);

        // Evento de dominio, aplica el evento de dominio sobre el show
        //events.forEach(event -> show.applyEvent(event))
        events.forEach(utileria::applyEvent);

        return utileria;
    }

    // métodos del agregado [AR]Utileria



}
