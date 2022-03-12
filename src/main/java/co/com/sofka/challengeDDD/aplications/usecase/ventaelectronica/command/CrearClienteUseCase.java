package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.ventaelectronica.VentaElectronica;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.CrearCliente;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {

    // Se implementa el método

    @Override
    public void executeUseCase(RequestCommand<CrearCliente> input) {

        var command = input.getCommand();
        // se crea una nueva instancia
        var ventaElectronica = VentaElectronica.from (command.getVentaElectronicaId(), command.getShowId(), retrieveEvents());
        ventaElectronica.crearCliente(command.getClienteId(), command.getNombre(), command.getIdentificacion(), command.getEmail());
        emit().onResponse(new ResponseEvents(ventaElectronica.getUncommittedChanges()));
    }
}
