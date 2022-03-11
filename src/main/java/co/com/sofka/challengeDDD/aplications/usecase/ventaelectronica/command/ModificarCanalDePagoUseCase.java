package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.domain.utileria.Utileria;
import co.com.sofka.challengeDDD.domain.ventaelectronica.VentaElectronica;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.ModificarCanalDePago;

public class ModificarCanalDePagoUseCase extends UseCase<RequestCommand<ModificarCanalDePago>, ResponseEvents> {

    // se implementa el método
    @Override
    public void executeUseCase(RequestCommand<ModificarCanalDePago> input) {

        var command =  input.getCommand();
        // se recoge la instancia
        var ventaElectronica = VentaElectronica.from(command.getVentaElectronicaId(), command.getShowId(), retrieveEvents());
        ventaElectronica.modificarCanalDePago(command.getCanalDePagoId(), command.getCanalPagoProveedor(), command.getPoliticaDeRetiro());
        emit().onResponse(new ResponseEvents(ventaElectronica.getUncommittedChanges()));

    }
}
