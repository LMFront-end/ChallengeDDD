package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event.logs.GenerarTransaccionLog;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.TransaccionCreada;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.TransaccionId;

import java.util.List;

public class TransaccionCreadaUseCase extends UseCase<TriggeredEvent<TransaccionCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<TransaccionCreada> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarTransaccionLog.class).orElseThrow();
        boolean isGenerated = service.generate(TransaccionId.of(event.aggregateRootId()), "Transaccion creada");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo crear la transaccion");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
