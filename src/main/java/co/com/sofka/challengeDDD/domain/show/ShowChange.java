package co.com.sofka.challengeDDD.domain.show;

import co.com.sofka.challengeDDD.domain.show.entities.CanalDeTransmision;
import co.com.sofka.challengeDDD.domain.show.entities.Modelo;
import co.com.sofka.challengeDDD.domain.show.entities.Monitor;
import co.com.sofka.challengeDDD.domain.show.events.*;
import co.com.sofka.domain.generic.EventChange;

public class ShowChange extends EventChange {

    public ShowChange(Show show) {

        apply((ShowCreado event) -> {
            show.showId = event.getShowId();
        });

        // Métodos

        // asignarModelo()
        apply((ModeloAsignada event) -> {
            show.modelo = new Modelo(
                    event.getModeloId(),
                    event.getNombre(),
                    event.getIdentificacion(),
                    event.getEmail()
            );
        });

        // cambiarModelo()
        apply((ModeloCambiada event) ->{
            show.modelo.cambiarNombre(event.getNombre());
            show.modelo.cambiarEmail(event.getEmail());
            show.modelo.cambiarIdentificacion(event.getIdentificacion());
        });

        // asignarMonitor()
        apply((MonitorAsignado event) -> {
            show.monitor = new Monitor(
                    event.getMonitorId(),
                    event.getNombre(),
                    event.getIdentificacion(),
                    event.getAcuerdoDeConfidencialidad()
            );
        });

        // cambiarMonitor()
        apply((MonitorCambiado event) ->{
            show.monitor.cambiarNombre(event.getNombre());
            show.monitor.cambiarIdentificacion(event.getIdentificacion());
            show.monitor.cambiarAcuerdoDeConfidencialidad(event.getAcuerdoDeConfidencialidad());
        });

        // asignarCanalDeTransmision()
        apply((CanalDeTransmisionAsignado event) -> {
            show.canalDeTransmision = new CanalDeTransmision(
                    event.getCanalDeTransmisionId(),
                    event.getAcuerdoDePago(),
                    event.getPaginasDeTransmision()
            );
        });

        // cambiarCanalDeTransmision()
        apply((CanalDeTransmisionCambiado event) ->{
            show.canalDeTransmision.cambiarPaginasDeTransmision(event.getPaginasDeTransmision());
            show.canalDeTransmision.cambiarAcuerdoDePago(event.getAcuerdoDePago());
        });
    }
    
}
