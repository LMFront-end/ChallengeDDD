package co.com.sofka.challengeDDD.domain.show.commands;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CrearShow extends Command{

    private final ShowId showId;

}
