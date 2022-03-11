package co.com.sofka.challengeDDD.domain.show;

import co.com.sofka.challengeDDD.domain.show.entities.Modelo;
import co.com.sofka.challengeDDD.domain.show.events.ModeloAsignada;
import co.com.sofka.challengeDDD.domain.show.events.ShowCreado;
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


        // asignarMonitor()
        // cambiarMonitor()
        // asignarCanalDeTransmision()
        // cambiarCanalDeTransmision()
    }


}
