package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.ventaelectronica.VentaElectronica;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.CrearVentaElectronica;

public class CrearVentaElectronicaUseCase extends UseCase<RequestCommand<CrearVentaElectronica>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<CrearVentaElectronica> input) {

        var command = input.getCommand();
        var ventaElectronica = new VentaElectronica(command.getVentaElectronicaId(), command.getShowId());
        emit().onResponse(new ResponseEvents(ventaElectronica.getUncommittedChanges()));
    }
}
