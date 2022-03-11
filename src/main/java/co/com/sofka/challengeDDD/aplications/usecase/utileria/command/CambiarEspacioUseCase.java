package co.com.sofka.challengeDDD.aplications.usecase.utileria.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.utileria.Utileria;
import co.com.sofka.challengeDDD.domain.utileria.commands.CambiarEspacio;

public class CambiarEspacioUseCase extends UseCase<RequestCommand<CambiarEspacio>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<CambiarEspacio> input) {

        var command =  input.getCommand();
        // se recoge la instancia
        var utileria = Utileria.from(command.getUtileriaID(), command.getShowId(), retrieveEvents());
        utileria.cambiarEspacio(command.getEspacioId(), command.getUtileriaID(), command.getTipoHabitacion(), command.getEstadoHabitacion());
        emit().onResponse(new ResponseEvents(utileria.getUncommittedChanges()));

    }
}
