package co.com.sofka.challengeDDD.domain.utileria.events;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter
public class UtileriaCreada extends DomainEvent {
    
    private final UtileriaID utileriaID;
    private final ShowId showId;


    public UtileriaCreada(UtileriaID utileriaID, ShowId showId) {
        super("co.com.sofka.challengeDDD.UtileriaCreada");
        this.utileriaID = utileriaID;
        this.showId = showId;
    }
}
