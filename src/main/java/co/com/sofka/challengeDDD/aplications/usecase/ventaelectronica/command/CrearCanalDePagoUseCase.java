package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.ventaelectronica.VentaElectronica;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.CrearCanalDePago;

public class CrearCanalDePagoUseCase extends UseCase<RequestCommand<CrearCanalDePago>, ResponseEvents> {

    // Se implementa el método
    @Override
    public void executeUseCase(RequestCommand<CrearCanalDePago> input) {

        var command = input.getCommand();
        // se crea una nueva instancia
        var ventaElectronica = new VentaElectronica(command.getVentaElectronicaId(), command.getShowId());
        emit().onResponse(new ResponseEvents(ventaElectronica.getUncommittedChanges()));



    }
}
