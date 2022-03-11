package co.com.sofka.challengeDDD.aplications.usecase.show.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.show.Show;
import co.com.sofka.challengeDDD.domain.show.commands.AsignarModelo;

public class AsignarModeloUseCase extends UseCase<RequestCommand<AsignarModelo>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<AsignarModelo> input) {

        var command =  input.getCommand();
        // se recoge la instancia
        var show = Show.from(command.getShowId(), retrieveEvents());
        show.asignarModelo(command.getModeloId(), command.getNombre(), command.getIdentificacion(), command.getEmail());
        emit().onResponse(new ResponseEvents(show.getUncommittedChanges()));
    }
}
