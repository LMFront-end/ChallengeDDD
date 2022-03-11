package co.com.sofka.challengeDDD.aplications.usecase.show.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.show.event.logs.GenerarShowLog;
import co.com.sofka.challengeDDD.domain.show.events.ShowCreado;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;

import java.util.List;

public class ShowCreadoUseCase extends UseCase<TriggeredEvent<ShowCreado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ShowCreado> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarShowLog.class).orElseThrow();
        boolean isGenerated = service.generate(ShowId.of(event.aggregateRootId()), "Show creado");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo crear el show");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
