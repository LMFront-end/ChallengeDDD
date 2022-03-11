package co.com.sofka.challengeDDD.aplications.usecase.utileria.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.utileria.Utileria;
import co.com.sofka.challengeDDD.domain.utileria.commands.EliminarInsumoElectronico;

public class EliminarInsumoElectronicoUseCase extends UseCase<RequestCommand<EliminarInsumoElectronico>, ResponseEvents> {

    // Se implementa el método
    @Override
    public void executeUseCase(RequestCommand<EliminarInsumoElectronico> input) {


        var command =  input.getCommand();
        // Se recoge la instancia
        // se debe pasar la referencia de showId
        var utileria = Utileria.from(command.getUtileriaID(), command.getShowId(), retrieveEvents());
        utileria.eliminarInsumoElectronico(command.getInsumoID());
        emit().onResponse(new ResponseEvents(utileria.getUncommittedChanges()));
    }
}
