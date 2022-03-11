package co.com.sofka.challengeDDD.domain.show.events;

import co.com.sofka.challengeDDD.domain.show.ids.CanalDeTransmisionId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDePago;
import co.com.sofka.challengeDDD.domain.show.valueobjects.PaginasDeTransmision;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter
public class CanalDeTransmisionCambiado extends DomainEvent {

    private final CanalDeTransmisionId canalDeTransmisionId;
    private final AcuerdoDePago acuerdoDePago;
    private final PaginasDeTransmision paginasDeTransmision;

    public CanalDeTransmisionCambiado(CanalDeTransmisionId canalDeTransmisionId, AcuerdoDePago acuerdoDePago, PaginasDeTransmision paginasDeTransmision) {
        super("co.com.sofka.challengeDDD.CanalDeTransmisionCambiado");
        this.canalDeTransmisionId = canalDeTransmisionId;
        this.acuerdoDePago = acuerdoDePago;
        this.paginasDeTransmision = paginasDeTransmision;
    }
}
