package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.CrearCanalDePago;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.CanalDePagoCreado;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.CanalDePagoId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.CanalPagoProveedor;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.PoliticaDeRetiro;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.properties_values.CanalPagoProveedorValue;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.properties_values.PoliticaDeRetiroValue;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CrearCanalDePagoUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void crearCanalDePagoUseCaseTest(){

        ShowId showId = ShowId.of("1458");
        VentaElectronicaId ventaElectronicaId = VentaElectronicaId.of("7415");
        CanalDePagoId canalDePagoId = CanalDePagoId.of("7859");

        // se crean instancias de los objetos de valor de la entidad
        CanalPagoProveedor canalPagoProveedor = new CanalPagoProveedor(CanalPagoProveedorValue.NEQUI);
        PoliticaDeRetiro politicaDeRetiro  = new PoliticaDeRetiro(PoliticaDeRetiroValue.RETIRO_MAXIMO);

        // se crea una lista de dominio
        List<DomainEvent> mockEvents = List.of(new CanalDePagoCreado(canalDePagoId, canalPagoProveedor, politicaDeRetiro));

        // se pasa la referencia de id show
        var command = new CrearCanalDePago(showId, ventaElectronicaId, canalDePagoId, canalPagoProveedor, politicaDeRetiro );
        var useCase = new CrearCanalDePagoUseCase();

        // se llama a la lista de dominio
        Mockito.when(domainEventRepository.getEventsBy(canalDePagoId.value())).thenReturn(mockEvents);

        useCase.addRepository(domainEventRepository);

        //UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(canalDePagoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // events.get(0) --> show creado
        var event = (CanalDePagoCreado) events.get(1);

        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(ventaElectronicaId.toString(), event.aggregateRootId());

        Assertions.assertEquals(canalDePagoId, event.getCanalDePagoId());
        Assertions.assertEquals(canalPagoProveedor, event.getCanalPagoProveedor());
        Assertions.assertEquals(politicaDeRetiro, event.getPoliticaDeRetiro());




    }


}