package co.com.sofka.challengeDDD.domain.ventaelectronica.events;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;


@Getter
public class VentaElectronicaCreada extends DomainEvent {

    private final VentaElectronicaId ventaElectronicaId;
    private final ShowId showId;

    public VentaElectronicaCreada(VentaElectronicaId ventaElectronicaId, ShowId showId) {
        super("co.com.sofka.challengeDDD.VentaElectronicaCreada");
        this.ventaElectronicaId = ventaElectronicaId;
        this.showId = showId;
    }
}
