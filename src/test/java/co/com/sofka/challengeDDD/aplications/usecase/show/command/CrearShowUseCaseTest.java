package co.com.sofka.challengeDDD.aplications.usecase.show.command;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.domain.show.commands.CrearShow;
import co.com.sofka.challengeDDD.domain.show.events.ShowCreado;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CrearShowUseCaseTest {

    @Test
    void crearShowUseCaseTest(){
        ShowId showId = ShowId.of("123456");
        var command = new CrearShow(showId);
        var useCase = new CrearShowUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        var event = (ShowCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals(showId.toString() , event.aggregateRootId());

    }
}