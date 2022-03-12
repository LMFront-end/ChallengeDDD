package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.generics.Email;
import co.com.sofka.challengeDDD.domain.generics.Identificacion;
import co.com.sofka.challengeDDD.domain.generics.Nombre;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.CrearCliente;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.ClienteCreado;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.ClienteId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class CrearClienteUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void crearClienteUseCaseTest(){

        ShowId showId = ShowId.of("1458");
        VentaElectronicaId ventaElectronicaId = VentaElectronicaId.of("7415");
        ClienteId clienteId = ClienteId.of("xxx");

        // se crean instancias de los objetos de valor de la entidad
        Nombre nombre = new Nombre("Santiago", "Vlad");
        Identificacion identificacion = new Identificacion("xxxx");
        Email email = new Email("SantiagoVlad");

        // se crea una lista de dominio
        List<DomainEvent> mockEvents = List.of(new ClienteCreado(clienteId, nombre, identificacion, email));

        // se pasa la referencia de id show
        var command = new CrearCliente(showId, ventaElectronicaId, clienteId, nombre, identificacion, email );
        var useCase = new CrearClienteUseCase();

        // se llama a la lista de dominio
        Mockito.when(domainEventRepository.getEventsBy(clienteId.value())).thenReturn(mockEvents);

        useCase.addRepository(domainEventRepository);

        //UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(clienteId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // events.get(0) --> show creado
        var event = (ClienteCreado) events.get(1);

        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(ventaElectronicaId.toString(), event.aggregateRootId());

        Assertions.assertEquals(clienteId, event.getClienteId());
        Assertions.assertEquals(nombre, event.getNombre());
        Assertions.assertEquals(identificacion, event.getIdentificacion());
        Assertions.assertEquals(email, event.getEmail());

    }

}