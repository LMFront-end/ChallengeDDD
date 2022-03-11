package co.com.sofka.challengeDDD.aplications.usecase.show.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.show.Show;
import co.com.sofka.challengeDDD.domain.show.commands.AsignarMonitor;

public class AsignarMonitorUseCase extends UseCase<RequestCommand<AsignarMonitor>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<AsignarMonitor> input) {

        var command =  input.getCommand();
        // se recoge la instancia
        var show = Show.from(command.getShowId(), retrieveEvents());
        show.asignarMonitor(command.getMonitorId(), command.getNombre(), command.getIdentificacion(), command.getAcuerdoDeConfidencialidad());
        emit().onResponse(new ResponseEvents(show.getUncommittedChanges()));
    }
}
