package co.com.sofka.challengeDDD.usecase.show.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.show.Show;
import co.com.sofka.challengeDDD.domain.show.commands.CrearShow;

public class CrearShowUseCase extends UseCase<RequestCommand<CrearShow>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<CrearShow> input) {

        var command = input.getCommand();
        var show = new Show(command.getShowId());
        emit().onResponse(new ResponseEvents(show.getUncommittedChanges()));
    }
}
