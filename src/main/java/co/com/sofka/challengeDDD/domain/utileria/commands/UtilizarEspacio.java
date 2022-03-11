package co.com.sofka.challengeDDD.domain.utileria.commands;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.ids.EspacioID;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoHabitacion;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoHabitacion;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UtilizarEspacio extends Command {

    private final ShowId showId;
    private final UtileriaID utileriaID;
    private final EspacioID espacioId;
    private final TipoHabitacion tipoHabitacion;
    private final EstadoHabitacion estadoHabitacion;
    
}
