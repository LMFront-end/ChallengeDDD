package co.com.sofka.challengeDDD.aplications.usecase.utileria.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.show.event.logs.GenerarModeloLog;
import co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs.GenerarEspacioLog;
import co.com.sofka.challengeDDD.domain.show.events.ModeloAsignada;
import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;
import co.com.sofka.challengeDDD.domain.utileria.events.EspacioUtilizado;
import co.com.sofka.challengeDDD.domain.utileria.ids.EspacioID;

import java.util.List;

public class EspacioUtilizadoUseCase extends UseCase<TriggeredEvent<EspacioUtilizado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<EspacioUtilizado> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarEspacioLog.class).orElseThrow();
        Boolean isGenerated = service.generate(EspacioID.of(event.aggregateRootId()), "Espacio utilizado");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo utilizar el espacio");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
