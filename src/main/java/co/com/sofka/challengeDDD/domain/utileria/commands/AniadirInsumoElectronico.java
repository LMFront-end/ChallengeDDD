package co.com.sofka.challengeDDD.domain.utileria.commands;

import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoInsumo;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoDeInsumo;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AniadirInsumoElectronico extends Command {

        private final InsumoID insumoID;
        private final TipoDeInsumo tipoDeInsumo;
        private final EstadoInsumo estadoInsumo;

}