package co.com.sofka.challengeDDD.domain.utileria.commands;


import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EliminarInsumoElectronico extends Command {

    private final ShowId showId;
    private final UtileriaID utileriaID;
    private final InsumoID insumoID;

}
