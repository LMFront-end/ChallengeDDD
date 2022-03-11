package co.com.sofka.challengeDDD.aplications.usecase.utileria.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.utileria.Utileria;
import co.com.sofka.challengeDDD.domain.utileria.commands.AniadirInsumoElectronico;

public class AniadirInsumoElectronicoUseCase extends UseCase<RequestCommand<AniadirInsumoElectronico>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<AniadirInsumoElectronico> input) {

        var command =  input.getCommand();
        // se recoge la instancia
        // se debe pasar la referencia de showId
        var utileria = Utileria.from(command.getUtileriaID(), command.getShowId(), retrieveEvents());
        utileria.aniadirInsumoElectronico(command.getInsumoID(), command.getTipoDeInsumo(), command.getEstadoInsumo());
        emit().onResponse(new ResponseEvents(utileria.getUncommittedChanges()));
    }

}
