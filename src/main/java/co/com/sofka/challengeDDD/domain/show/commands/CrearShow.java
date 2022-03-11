package co.com.sofka.challengeDDD.domain.show.commands;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;

@Getter
public class CrearShow extends Command{

    private final ShowId showId;

    // se implementa constructor
    public CrearShow(ShowId showId) {
        this.showId = showId;
    }

}
