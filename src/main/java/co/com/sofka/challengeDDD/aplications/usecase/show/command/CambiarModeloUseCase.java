package co.com.sofka.challengeDDD.aplications.usecase.show.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.show.Show;
import co.com.sofka.challengeDDD.domain.show.commands.AsignarModelo;
import co.com.sofka.challengeDDD.domain.show.commands.CambiarModelo;

public class CambiarModeloUseCase extends UseCase<RequestCommand<CambiarModelo>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<CambiarModelo> input) {

        var command =  input.getCommand();
        // se recoge la instancia
        var show = Show.from(command.getShowId(), retrieveEvents());
        show.cambiarModelo(command.getModeloId(), command.getNombre(), command.getIdentificacion(), command.getEmail());
        emit().onResponse(new ResponseEvents(show.getUncommittedChanges()));
    }
}
