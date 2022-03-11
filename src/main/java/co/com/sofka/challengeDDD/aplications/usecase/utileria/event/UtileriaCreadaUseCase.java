package co.com.sofka.challengeDDD.aplications.usecase.utileria.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs.GenerarUtileriaLog;
import co.com.sofka.challengeDDD.domain.utileria.events.UtileriaCreada;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;

import java.util.List;

public class UtileriaCreadaUseCase extends UseCase<TriggeredEvent<UtileriaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<UtileriaCreada> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarUtileriaLog.class).orElseThrow();
        boolean isGenerated = service.generate(UtileriaID.of(event.aggregateRootId()), "Utileria creada");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo generar la utileria");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
