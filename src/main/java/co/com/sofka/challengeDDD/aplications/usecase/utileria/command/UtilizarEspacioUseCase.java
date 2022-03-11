package co.com.sofka.challengeDDD.aplications.usecase.utileria.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.utileria.Utileria;
import co.com.sofka.challengeDDD.domain.utileria.commands.UtilizarEspacio;

public class UtilizarEspacioUseCase extends UseCase<RequestCommand<UtilizarEspacio>, ResponseEvents> {

    // implementar método
    @Override
    public void executeUseCase(RequestCommand<UtilizarEspacio> input) {

        // Se recoge la instancia
        // se debe pasar la referencia de showId
        var command = input.getCommand();

        var utileria = Utileria.from(command.getUtileriaID(), command.getShowId(), retrieveEvents());
        utileria.utilizarEspacio(command.getEspacioId(), command.getTipoHabitacion(), command.getEstadoHabitacion());
        emit().onResponse(new ResponseEvents(utileria.getUncommittedChanges()));
    }
}
