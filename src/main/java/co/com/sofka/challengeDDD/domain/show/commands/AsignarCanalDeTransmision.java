package co.com.sofka.challengeDDD.domain.show.commands;
import co.com.sofka.challengeDDD.domain.show.ids.CanalDeTransmisionId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDePago;
import co.com.sofka.challengeDDD.domain.show.valueobjects.PaginasDeTransmision;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;

@Getter
public class AsignarCanalDeTransmision extends Command{
    private final CanalDeTransmisionId canalDeTransmisionId;
    private final AcuerdoDePago acuerdoDePago;
    private final PaginasDeTransmision paginasDeTransmision;

    public AsignarCanalDeTransmision(CanalDeTransmisionId canalDeTransmisionId, AcuerdoDePago acuerdoDePago, 
                                     PaginasDeTransmision paginasDeTransmision) {
        this.canalDeTransmisionId = canalDeTransmisionId;
        this.acuerdoDePago = acuerdoDePago;
        this.paginasDeTransmision = paginasDeTransmision;
    }
    
}
