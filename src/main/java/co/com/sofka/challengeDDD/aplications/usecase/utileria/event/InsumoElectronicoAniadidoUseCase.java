package co.com.sofka.challengeDDD.aplications.usecase.utileria.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs.GenerarInsumoElectronicoLog;
import co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs.GenerarUtileriaLog;
import co.com.sofka.challengeDDD.domain.utileria.events.InsumoElectronicoAniadido;
import co.com.sofka.challengeDDD.domain.utileria.events.UtileriaCreada;
import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;

import java.util.List;

public class InsumoElectronicoAniadidoUseCase extends UseCase<TriggeredEvent<InsumoElectronicoAniadido>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<InsumoElectronicoAniadido> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarInsumoElectronicoLog.class).orElseThrow();
        boolean isGenerated = service.generate(InsumoID.of(event.aggregateRootId()), "Insumo electronico creado");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo añadir el insumo electronico");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
