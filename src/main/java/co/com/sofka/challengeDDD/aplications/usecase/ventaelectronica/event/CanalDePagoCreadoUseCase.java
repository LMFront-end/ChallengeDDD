package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event.logs.GenerarCanalDePagoLog;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.CanalDePagoCreado;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.CanalDePagoId;

import java.util.List;

public class CanalDePagoCreadoUseCase extends UseCase<TriggeredEvent<CanalDePagoCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CanalDePagoCreado> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarCanalDePagoLog.class).orElseThrow();
        boolean isGenerated = service.generate(CanalDePagoId.of(event.aggregateRootId()), "Canal de pago creado");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo crear el canal de pago");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
