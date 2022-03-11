package co.com.sofka.challengeDDD.aplications.usecase.show.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.show.event.logs.GenerarModeloLog;
import co.com.sofka.challengeDDD.domain.show.events.ModeloAsignada;
import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;

import java.util.List;

public class ModeloAsignadaUseCase extends UseCase<TriggeredEvent<ModeloAsignada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ModeloAsignada> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarModeloLog.class).orElseThrow();
        Boolean isGenerated = service.generate(ModeloId.of(event.aggregateRootId()), "Modelo asignada");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo asignar la modelo");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
