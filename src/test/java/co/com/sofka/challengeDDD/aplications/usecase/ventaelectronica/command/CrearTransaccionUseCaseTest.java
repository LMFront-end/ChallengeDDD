package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.CrearTransaccion;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.TransaccionCreada;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.TransaccionId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.Fecha;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.ValorMoneda;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class CrearTransaccionUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void crearTransaccionUseCaseTest(){

        ShowId showId = ShowId.of("1458");
        VentaElectronicaId ventaElectronicaId = VentaElectronicaId.of("7415");
        TransaccionId transaccionId = TransaccionId.of("xxx");

        // se crean instancias de los objetos de valor de la entidad
        ValorMoneda valorMoneda = new ValorMoneda(2.4);
        Fecha fecha = new Fecha(Date.from(Instant.now()));

        // se crea una lista de dominio
        List<DomainEvent> mockEvents = List.of(new TransaccionCreada(transaccionId, valorMoneda, fecha));

        // se pasa la referencia de id show
        var command = new CrearTransaccion(showId, ventaElectronicaId, transaccionId, valorMoneda, fecha );
        var useCase = new CrearTransaccionUseCase();

        // se llama a la lista de dominio
        Mockito.when(domainEventRepository.getEventsBy(transaccionId.value())).thenReturn(mockEvents);

        useCase.addRepository(domainEventRepository);

        //UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(transaccionId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // events.get(0) --> show creado
        var event = (TransaccionCreada) events.get(1);

        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(ventaElectronicaId.toString(), event.aggregateRootId());

        Assertions.assertEquals(transaccionId, event.getTransaccionId());
        Assertions.assertEquals(valorMoneda, event.getValorMoneda());
        Assertions.assertEquals(fecha, event.getFecha());


    }

}