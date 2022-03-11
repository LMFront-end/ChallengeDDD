package co.com.sofka.challengeDDD.aplications.usecase.show.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.show.event.logs.GenerarMonitorLog;
import co.com.sofka.challengeDDD.domain.show.events.MonitorAsignado;
import co.com.sofka.challengeDDD.domain.show.ids.MonitorId;

import java.util.List;

public class MonitorAsignadoUseCase extends UseCase<TriggeredEvent<MonitorAsignado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<MonitorAsignado> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarMonitorLog.class).orElseThrow();
        Boolean isGenerated = service.generate(MonitorId.of(event.aggregateRootId()), "Monitor asignado");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo asignar el monitor");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
