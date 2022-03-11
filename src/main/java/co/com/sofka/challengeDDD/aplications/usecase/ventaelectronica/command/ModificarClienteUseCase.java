package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.ventaelectronica.VentaElectronica;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.ModificarCliente;

public class ModificarClienteUseCase extends UseCase<RequestCommand<ModificarCliente>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<ModificarCliente> input) {

        var command =  input.getCommand();
        // se recoge la instancia
        var ventaElectronica = VentaElectronica.from(command.getVentaElectronicaId(), command.getShowId(), retrieveEvents());
        ventaElectronica.modificarCliente(command.getClienteId(), command.getNombre(), command.getIdentificacion(), command.getEmail());
        emit().onResponse(new ResponseEvents(ventaElectronica.getUncommittedChanges()));

    }
}
