package co.com.sofka.challengeDDD.domain.show.commands;
import co.com.sofka.challengeDDD.domain.show.ids.MonitorId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDeConfidencialidad;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;

@Getter
public class CambiarMonitor extends Command{

    private final MonitorId monitorId;
        private final Nombre nombre;
        private final Identificacion identificacion;
        private final AcuerdoDeConfidencialidad acuerdoDeConfidencialidad;

        public CambiarMonitor(MonitorId monitorId, Nombre nombre, Identificacion identificacion, AcuerdoDeConfidencialidad acuerdoDeConfidencialidad) {
            this.monitorId = monitorId;
            this.nombre = nombre;
            this.identificacion = identificacion;
            this.acuerdoDeConfidencialidad = acuerdoDeConfidencialidad;
        }

}
