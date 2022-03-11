package co.com.sofka.challengeDDD.aplications.usecase.utileria.command;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.utileria.Utileria;
import co.com.sofka.challengeDDD.domain.utileria.commands.EliminarProducto;

public class EliminarProductoUseCase extends UseCase<RequestCommand<EliminarProducto>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<EliminarProducto> input) {

        // se implementa el método
        var command =  input.getCommand();
        // Se recoge la instancia
        // se debe pasar la referencia de showId

        var utileria = Utileria.from(command.getUtileriaID(), command.getShowId(), retrieveEvents());
        utileria.eliminarProducto(command.getProductoID());
        emit().onResponse(new ResponseEvents(utileria.getUncommittedChanges()));

    }
}
