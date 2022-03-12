package co.com.sofka.challengeDDD.aplications.usecase.show.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.generics.Identificacion;
import co.com.sofka.challengeDDD.domain.generics.Nombre;
import co.com.sofka.challengeDDD.domain.show.commands.AsignarMonitor;
import co.com.sofka.challengeDDD.domain.show.events.MonitorAsignado;
import co.com.sofka.challengeDDD.domain.show.ids.MonitorId;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDeConfidencialidad;
import co.com.sofka.challengeDDD.domain.show.valueobjects.properties_values.AcuerdoDeConfidencialidadValue;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AsignarMonitorUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void asignarMonitorUseCaseTest(){

        ShowId showId = ShowId.of("1234");
        MonitorId monitorId = MonitorId.of("3456");

        // se crean instancias de los objetos de valor de la entidad
        Nombre nombre = new Nombre("Juan Pablo", "O'Brien");
        Identificacion identificacion = new Identificacion("12356");
        AcuerdoDeConfidencialidad acuerdoDeConfidencialidad = new AcuerdoDeConfidencialidad(AcuerdoDeConfidencialidadValue.ACEPTADO);

        // se crea una lista de dominio
        List<DomainEvent> mockEvents = List.of(new MonitorAsignado(monitorId, nombre, identificacion, acuerdoDeConfidencialidad));

        // comando
        var command = new AsignarMonitor(showId, monitorId, nombre, identificacion, acuerdoDeConfidencialidad);
        var useCase = new AsignarMonitorUseCase();

        Mockito.when(domainEventRepository.getEventsBy(monitorId.value())).thenReturn(mockEvents);

        useCase.addRepository(domainEventRepository);

        //UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(monitorId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // events.get(0) --> show creado
        var event = (MonitorAsignado) events.get(1);

        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(showId.toString(), event.aggregateRootId());

        // getShowId -> devuelve un elemento de tipo Identity
        Assertions.assertEquals(monitorId, event.getMonitorId());
        Assertions.assertEquals(nombre, event.getNombre());
        Assertions.assertEquals(identificacion, event.getIdentificacion());
        Assertions.assertEquals(acuerdoDeConfidencialidad, event.getAcuerdoDeConfidencialidad());


    }

}