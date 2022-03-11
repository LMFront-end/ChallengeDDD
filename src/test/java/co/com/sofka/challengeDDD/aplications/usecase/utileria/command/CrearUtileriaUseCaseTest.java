package co.com.sofka.challengeDDD.aplications.usecase.utileria.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.commands.CrearUtileria;
import co.com.sofka.challengeDDD.domain.utileria.events.UtileriaCreada;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearUtileriaUseCaseTest {


    @Test
    void crearUtileriaUseCaseTest(){

        // se llama al idShow
        ShowId showId = ShowId.of("1234");
        UtileriaID utileriaID = UtileriaID.of("78965");

        // se pasa la referencia de id
        var command = new CrearUtileria(utileriaID, showId);
        var useCase = new CrearUtileriaUseCase();

        // UseCaseHandler --> librería sofka
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        var event = (UtileriaCreada) events.getDomainEvents().get(0);
        // aggregateRootId --> Devuelve un string
        Assertions.assertEquals(utileriaID.toString(), event.aggregateRootId());

        // getShowId -> devuelve un elemento de tipo Identity
        Assertions.assertEquals(showId, event.getShowId());

    }


}