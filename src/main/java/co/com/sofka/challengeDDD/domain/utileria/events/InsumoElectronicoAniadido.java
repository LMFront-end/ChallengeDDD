package co.com.sofka.challengeDDD.domain.utileria.events;

import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoInsumo;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoDeInsumo;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class InsumoElectronicoAniadido extends DomainEvent {

    private final InsumoID insumoID;
    private final TipoDeInsumo tipoDeInsumo;
    private final EstadoInsumo estadoInsumo;

    public InsumoElectronicoAniadido(InsumoID insumoID, TipoDeInsumo tipoDeInsumo, EstadoInsumo estadoInsumo) {
        super("co.com.sofka.challengeDDD.InsumoElectronicoAniadido");
        this.insumoID = insumoID;
        this.tipoDeInsumo = tipoDeInsumo;
        this.estadoInsumo = estadoInsumo;
    }
}
