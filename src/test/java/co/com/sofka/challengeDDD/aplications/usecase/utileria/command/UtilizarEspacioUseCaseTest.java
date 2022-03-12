package co.com.sofka.challengeDDD.aplications.usecase.utileria.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.show.events.MonitorAsignado;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.commands.UtilizarEspacio;
import co.com.sofka.challengeDDD.domain.utileria.events.EspacioUtilizado;
import co.com.sofka.challengeDDD.domain.utileria.ids.EspacioID;
import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoHabitacion;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoHabitacion;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.EstadoHabitacionValue;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.TipoHabitacionValue;
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
class UtilizarEspacioUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void utilizarEspacioUseCaseTest(){

        ShowId showId = ShowId.of("1234");
        UtileriaID utileriaID = UtileriaID.of("7596");
        EspacioID espacioID = EspacioID.of("7864");

        TipoHabitacion tipoHabitacion = new TipoHabitacion(TipoHabitacionValue.HABITACION_CANDY);
        EstadoHabitacion estadoHabitacion = new EstadoHabitacion(EstadoHabitacionValue.EN_SERVICIO);

        List<DomainEvent> mockEvents = List.of(new EspacioUtilizado(espacioID, tipoHabitacion, estadoHabitacion));


        var command = new UtilizarEspacio(showId, utileriaID, espacioID, tipoHabitacion, estadoHabitacion);
        var useCase = new UtilizarEspacioUseCase();

        Mockito.when(domainEventRepository.getEventsBy(espacioID.value())).thenReturn((mockEvents));

        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(espacioID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EspacioUtilizado) events.get(1);

        Assertions.assertEquals(utileriaID.toString(), event.aggregateRootId());
        Assertions.assertEquals(espacioID, event.getEntityId());
        Assertions.assertEquals(estadoHabitacion, event.getEstadoHabitacion());
        Assertions.assertEquals(tipoHabitacion, event.getTipoHabitacion());

    }

}