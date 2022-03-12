package co.com.sofka.challengeDDD.aplications.usecase.show.command;

import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.challengeDDD.domain.generics.Identificacion;
import co.com.sofka.challengeDDD.domain.generics.Nombre;
import co.com.sofka.challengeDDD.domain.show.ids.MonitorId;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDeConfidencialidad;
import co.com.sofka.challengeDDD.domain.show.valueobjects.properties_values.AcuerdoDeConfidencialidadValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AsignarMonitorUseCaseTest {

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    void asignarMonitorUseCaseTest(){

        ShowId showId = ShowId.of("1234");
        MonitorId monitorId = MonitorId.of("3456");

        // se crean instancias de los objetos de valor de la entidad
        Nombre nombre = new Nombre("Juan Pablo", "O'Brien");
        Identificacion identificacion = new Identificacion("12356");
        AcuerdoDeConfidencialidad acuerdoDeConfidencialidad = new AcuerdoDeConfidencialidad(AcuerdoDeConfidencialidadValue.ACEPTADO);

        // se crea una lista de dominio
    }

}