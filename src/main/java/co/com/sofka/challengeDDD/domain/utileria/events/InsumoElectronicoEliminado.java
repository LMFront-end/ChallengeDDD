package co.com.sofka.challengeDDD.domain.utileria.events;

import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter
public class InsumoElectronicoEliminado extends DomainEvent {

    private final InsumoID insumoID;

    public InsumoElectronicoEliminado(InsumoID insumoID) {
        super("co.com.sofka.challengeDDD.InsumoElectronicoAniadido");
        this.insumoID = insumoID;

    }
}
