package co.com.sofka.challengeDDD.domain.show;

import co.com.sofka.challengeDDD.domain.show.entities.CanalDeTransmision;
import co.com.sofka.challengeDDD.domain.show.entities.Modelo;
import co.com.sofka.challengeDDD.domain.show.entities.Monitor;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.domain.generic.AggregateEvent;

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
}
