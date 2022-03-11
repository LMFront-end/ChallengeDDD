package co.com.sofka.challengeDDD.domain.utileria;

import co.com.sofka.challengeDDD.domain.show.events.ShowCreado;
import co.com.sofka.challengeDDD.domain.utileria.events.UtileriaCreada;
import co.com.sofka.domain.generic.EventChange;

public class UtileriaChange extends EventChange {

    public UtileriaChange(Utileria utileria) {

        apply((UtileriaCreada event) -> {
            utileria.utileriaID = event.getUtileriaID();
            utileria.showId = event.getShowId();
        });
    }
}
