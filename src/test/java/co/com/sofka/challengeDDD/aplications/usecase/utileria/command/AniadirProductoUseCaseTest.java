package co.com.sofka.challengeDDD.aplications.usecase.utileria.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.commands.AniadirInsumoElectronico;
import co.com.sofka.challengeDDD.domain.utileria.commands.AniadirProducto;
import co.com.sofka.challengeDDD.domain.utileria.events.InsumoElectronicoAniadido;
import co.com.sofka.challengeDDD.domain.utileria.events.ProductoAniadido;
import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.*;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AniadirProductoUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void aniadirProductoUseCaseTest(){

        ShowId showId = ShowId.of("1234");
        UtileriaID utileriaID = UtileriaID.of("7596");
        ProductoID productoID = ProductoID.of("7864");

        // se crean instancias de los objetos de valor de la entidad
        TipoProductoJuguete tipoProductoJuguete = new TipoProductoJuguete(TipoProductoJugueteValue.DILDO_17CM);
        TipoProductoDisfraz tipoProductoDisfraz = new TipoProductoDisfraz(TipoProductoDisfrazValue.DISFRAZ_ANGEL);
        EstadoProducto estadoProducto = new EstadoProducto(EstadoProductoValue.EXCELENTE_ESTADO);

        // se crea una lista de dominio
        List<DomainEvent> mockEvents = List.of(new ProductoAniadido(productoID, tipoProductoJuguete, tipoProductoDisfraz, estadoProducto));

        // comando
        //var show = Show.from(showId, mockEvents());
        var command = new AniadirProducto(showId, utileriaID, productoID, tipoProductoJuguete, tipoProductoDisfraz, estadoProducto);
        var useCase = new AniadirProductoUseCase();

        Mockito.when(domainEventRepository.getEventsBy(productoID.value())).thenReturn(mockEvents);

        useCase.addRepository(domainEventRepository);

        //UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(productoID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // events.get(0) --> show creado
        var event = (ProductoAniadido) events.get(1);

        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(utileriaID.toString(), event.aggregateRootId());
        Assertions.assertEquals(productoID, event.getProductoID());
        Assertions.assertEquals(tipoProductoJuguete, event.getTipoProductoJuguete());
        Assertions.assertEquals(tipoProductoDisfraz, event.getTipoProductoDisfraz());
        Assertions.assertEquals(estadoProducto, event.getEstadoProducto());

    }

}