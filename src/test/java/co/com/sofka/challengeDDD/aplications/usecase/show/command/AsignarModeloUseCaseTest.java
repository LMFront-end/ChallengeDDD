package co.com.sofka.challengeDDD.aplications.usecase.show.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.generics.Email;
import co.com.sofka.challengeDDD.domain.generics.Identificacion;
import co.com.sofka.challengeDDD.domain.generics.Nombre;
import co.com.sofka.challengeDDD.domain.show.commands.AsignarModelo;
import co.com.sofka.challengeDDD.domain.show.events.ModeloAsignada;
import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AsignarModeloUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void asignarModeloUseCaseTest(){

        ShowId showId = ShowId.of("1236");
        ModeloId modeloId = ModeloId.of("1245");

        // se crean instancias de los objetos de valor de la entidad
        Nombre nombre = new Nombre("Lina Maria", "Guerrero");
        Identificacion identificacion = new Identificacion("147596");
        Email email = new Email("linaHola@gmail.com");

        // se crea una lista de dominio
        List<DomainEvent> mockEvents = List.of(new ModeloAsignada(modeloId, nombre, identificacion, email));

        // comando
        var command = new AsignarModelo(showId, modeloId, nombre, identificacion, email);
        var useCase = new AsignarModeloUseCase();

        // se llama a la lista de dominio
        Mockito.when(domainEventRepository.getEventsBy(modeloId.value())).thenReturn(mockEvents);

        useCase.addRepository(domainEventRepository);

        //UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(modeloId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // events.get(0) --> show creado
        var event = (ModeloAsignada) events.get(1);

        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(showId.toString(), event.aggregateRootId());

        // getShowId -> devuelve un elemento de tipo Identity
        Assertions.assertEquals(modeloId, event.getModeloId());
        Assertions.assertEquals(nombre, event.getNombre());
        Assertions.assertEquals(identificacion, event.getIdentificacion());
        Assertions.assertEquals(email, event.getEmail());
    }

}