package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.ventaelectronica.VentaElectronica;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.ModificarTransaccion;

public class ModificarTransaccionUseCase extends UseCase<RequestCommand<ModificarTransaccion>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<ModificarTransaccion> input) {

        var command =  input.getCommand();
        // se recoge la instancia
        var ventaElectronica = VentaElectronica.from(command.getVentaElectronicaId(), command.getShowId(), retrieveEvents());
        ventaElectronica.modificarTransaccion(command.getTransaccionId(), command.getValorMoneda(), command.getFecha());
        emit().onResponse(new ResponseEvents(ventaElectronica.getUncommittedChanges()));

    }
}
