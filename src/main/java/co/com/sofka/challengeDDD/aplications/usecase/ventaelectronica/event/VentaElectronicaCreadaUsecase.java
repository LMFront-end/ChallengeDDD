package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event.logs.GenerarVentaElectronicaLog;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.VentaElectronicaCreada;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;

import java.util.List;

public class VentaElectronicaCreadaUsecase extends UseCase<TriggeredEvent<VentaElectronicaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<VentaElectronicaCreada> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarVentaElectronicaLog.class).orElseThrow();
        var isGenerated = service.generate(VentaElectronicaId.of(event.aggregateRootId()), "Venta electronica creada");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo crear la venta electronica");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
