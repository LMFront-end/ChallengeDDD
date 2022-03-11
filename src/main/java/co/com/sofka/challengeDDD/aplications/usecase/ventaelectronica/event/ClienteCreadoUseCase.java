package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs.GenerarUtileriaLog;
import co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event.logs.GenerarClienteLog;
import co.com.sofka.challengeDDD.domain.utileria.events.UtileriaCreada;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.ClienteCreado;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.ClienteId;

import java.util.List;

public class ClienteCreadoUseCase extends UseCase<TriggeredEvent<ClienteCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ClienteCreado> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarClienteLog.class).orElseThrow();
        boolean isGenerated = service.generate(ClienteId.of(event.aggregateRootId()), "Cliente creado");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo crear el cliente");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
