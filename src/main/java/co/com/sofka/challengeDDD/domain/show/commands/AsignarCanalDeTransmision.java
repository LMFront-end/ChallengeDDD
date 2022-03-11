package co.com.sofka.challengeDDD.domain.show.commands;
import co.com.sofka.challengeDDD.domain.show.Show;
import co.com.sofka.challengeDDD.domain.show.ids.CanalDeTransmisionId;
import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.show.valueobjects.AcuerdoDePago;
import co.com.sofka.challengeDDD.domain.show.valueobjects.PaginasDeTransmision;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AsignarCanalDeTransmision extends Command{

    private final ShowId showId;
    private final CanalDeTransmisionId canalDeTransmisionId;
    private final AcuerdoDePago acuerdoDePago;
    private final PaginasDeTransmision paginasDeTransmision;

}
