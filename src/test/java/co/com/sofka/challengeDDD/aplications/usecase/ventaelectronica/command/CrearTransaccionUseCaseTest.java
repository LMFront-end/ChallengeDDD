package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.command;

import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.TransaccionId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CrearTransaccionUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void crearTransaccionUseCaseTest(){

        ShowId showId = ShowId.of("1458");
        VentaElectronicaId ventaElectronicaId = VentaElectronicaId.of("7415");
        TransaccionId transaccionId = TransaccionId.of("xxx");
    }

}