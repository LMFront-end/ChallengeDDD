package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.commands.CrearVentaElectronica;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.VentaElectronicaCreada;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearVentaElectronicaUseCaseTest {

    @Test
    void crearVentaElectronicaUseCaseTest(){

        // se llama al idShow
        ShowId showId = ShowId.of("1234");
        VentaElectronicaId ventaElectronicaId = VentaElectronicaId.of("7415");

        // se pasa la referencia de id show
        var command = new CrearVentaElectronica(ventaElectronicaId, showId);
        var useCase = new CrearVentaElectronicaUseCase();

        //UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        var event = (VentaElectronicaCreada) events.getDomainEvents().get(0);
        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(ventaElectronicaId.toString(), event.aggregateRootId());

        // getShowId -> devuelve un elemento de tipo Identity
        Assertions.assertEquals(showId, event.getShowId());
    }

}