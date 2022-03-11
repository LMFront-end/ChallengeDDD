package co.com.sofka.challengeDDD.usecase.utileria.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.utileria.Utileria;
import co.com.sofka.challengeDDD.domain.utileria.commands.CrearUtileria;

public class CrearUtileriaUseCase extends UseCase<RequestCommand<CrearUtileria>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<CrearUtileria> input) {

        var command = input.getCommand();
        var utileria = new Utileria(command.getUtileriaID(), command.getShowId());
        emit().onResponse(new ResponseEvents(utileria.getUncommittedChanges()));
    }
}
