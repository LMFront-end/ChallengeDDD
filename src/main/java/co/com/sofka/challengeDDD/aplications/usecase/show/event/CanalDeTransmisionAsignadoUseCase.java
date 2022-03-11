package co.com.sofka.challengeDDD.aplications.usecase.show.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.show.event.logs.GenerarCanalDeTransmisionLog;
import co.com.sofka.challengeDDD.domain.show.events.CanalDeTransmisionAsignado;
import co.com.sofka.challengeDDD.domain.show.ids.CanalDeTransmisionId;

import java.util.List;

public class CanalDeTransmisionAsignadoUseCase extends UseCase<TriggeredEvent<CanalDeTransmisionAsignado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CanalDeTransmisionAsignado> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarCanalDeTransmisionLog.class).orElseThrow();
        Boolean isGenerated = service.generate(CanalDeTransmisionId.of(event.aggregateRootId()), "Canal de transmision asignado");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo asignar el canal de transmision");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
