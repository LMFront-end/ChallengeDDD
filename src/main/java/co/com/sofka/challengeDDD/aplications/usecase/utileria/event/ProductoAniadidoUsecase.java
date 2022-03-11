package co.com.sofka.challengeDDD.aplications.usecase.utileria.event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs.GenerarProductoLog;
import co.com.sofka.challengeDDD.domain.utileria.events.ProductoAniadido;
import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;

import java.util.List;

public class ProductoAniadidoUsecase extends UseCase<TriggeredEvent<ProductoAniadido>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ProductoAniadido> input) {
        var event = input.getDomainEvent();
        var service = getService(GenerarProductoLog.class).orElseThrow();
        boolean isGenerated = service.generate(ProductoID.of(event.aggregateRootId()), "Producto añadido");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo añadir el producto");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
