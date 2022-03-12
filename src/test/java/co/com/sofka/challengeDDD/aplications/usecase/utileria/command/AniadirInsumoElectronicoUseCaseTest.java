package co.com.sofka.challengeDDD.aplications.usecase.utileria.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.aplications.usecase.show.command.AsignarCanalDeTransmisionUseCase;
import co.com.sofka.challengeDDD.domain.show.commands.AsignarCanalDeTransmision;
import co.com.sofka.challengeDDD.domain.show.events.CanalDeTransmisionAsignado;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.commands.AniadirInsumoElectronico;
import co.com.sofka.challengeDDD.domain.utileria.events.InsumoElectronicoAniadido;
import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoInsumo;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoDeInsumo;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.EstadoInsumoValue;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.TipoDeInsumoValue;
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
class AniadirInsumoElectronicoUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void aniadirInsumoElectronicoUseCaseTest(){

        ShowId showId = ShowId.of("1234");
        UtileriaID utileriaID = UtileriaID.of("7596");
        InsumoID insumoID = InsumoID.of("7864");

        // se crean instancias de los objetos de valor de la entidad
        TipoDeInsumo tipoDeInsumo = new TipoDeInsumo(TipoDeInsumoValue.ARO_DE_LUZ);
        EstadoInsumo estadoInsumo = new EstadoInsumo(EstadoInsumoValue.BUEN_ESTADO);

        // se crea una lista de dominio
        List<DomainEvent> mockEvents = List.of(new InsumoElectronicoAniadido(insumoID, tipoDeInsumo, estadoInsumo));

        // comando
        //var show = Show.from(showId, mockEvents());
        var command = new AniadirInsumoElectronico(showId, utileriaID, insumoID, tipoDeInsumo, estadoInsumo);
        var useCase = new AniadirInsumoElectronicoUseCase();

        Mockito.when(domainEventRepository.getEventsBy(insumoID.value())).thenReturn(mockEvents);

        useCase.addRepository(domainEventRepository);

        //UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(insumoID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // events.get(0) --> show creado
        var event = (InsumoElectronicoAniadido) events.get(1);

        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(utileriaID.toString(), event.aggregateRootId());

        Assertions.assertEquals(insumoID, event.getInsumoID());
        Assertions.assertEquals(tipoDeInsumo, event.getTipoDeInsumo());
        Assertions.assertEquals(estadoInsumo, event.getEstadoInsumo());

    }

}