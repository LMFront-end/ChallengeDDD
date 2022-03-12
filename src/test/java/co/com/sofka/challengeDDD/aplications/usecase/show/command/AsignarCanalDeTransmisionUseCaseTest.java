package co.com.sofka.challengeDDD.aplications.usecase.show.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.show.commands.AsignarCanalDeTransmision;
import co.com.sofka.challengeDDD.domain.show.events.CanalDeTransmisionAsignado;
import co.com.sofka.challengeDDD.domain.show.ids.CanalDeTransmisionId;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDePago;
import co.com.sofka.challengeDDD.domain.show.valueobjects.PaginasDeTransmision;
import co.com.sofka.challengeDDD.domain.show.valueobjects.properties_values.PaginaDeTransmisionValue;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AsignarCanalDeTransmisionUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void asignarCanalDeTransmisionUseCaseTest(){

        ShowId showId = ShowId.of("1234");
        CanalDeTransmisionId canalDeTransmisionId = CanalDeTransmisionId.of("1478");

        // se crean instancias de los objetos de valor de la entidad
        PaginasDeTransmision paginasDeTransmision = new PaginasDeTransmision(PaginaDeTransmisionValue.BONGOCAMS);
        AcuerdoDePago acuerdoDePago = new AcuerdoDePago(0.5);

        // se crea una lista de dominio
        List<DomainEvent> mockEvents = List.of(new CanalDeTransmisionAsignado(canalDeTransmisionId, acuerdoDePago, paginasDeTransmision));

        // comando
        //var show = Show.from(showId, mockEvents());
        var command = new AsignarCanalDeTransmision(showId, canalDeTransmisionId, acuerdoDePago, paginasDeTransmision);
        var useCase = new AsignarCanalDeTransmisionUseCase();

        Mockito.when(domainEventRepository.getEventsBy(canalDeTransmisionId.value())).thenReturn(mockEvents);

        useCase.addRepository(domainEventRepository);

        //UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(canalDeTransmisionId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // events.get(0) --> show creado
        var event = (CanalDeTransmisionAsignado) events.get(1);

        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(showId.toString(), event.aggregateRootId());

        // getShowId -> devuelve un elemento de tipo Identity
        Assertions.assertEquals(canalDeTransmisionId, event.getCanalDeTransmisionId());
        Assertions.assertEquals(paginasDeTransmision, event.getPaginasDeTransmision());
        Assertions.assertEquals(acuerdoDePago, event.getAcuerdoDePago());

    }


}