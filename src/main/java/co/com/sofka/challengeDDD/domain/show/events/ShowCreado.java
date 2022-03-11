package co.com.sofka.challengeDDD.domain.show.events;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter
public class ShowCreado extends DomainEvent {

    private final ShowId showId;

    // se implementa constructor
    public ShowCreado(ShowId showId) {
        super("co.com.sofka.challengeDDD.ShowCreado");
        this.showId = showId;
    }
}
