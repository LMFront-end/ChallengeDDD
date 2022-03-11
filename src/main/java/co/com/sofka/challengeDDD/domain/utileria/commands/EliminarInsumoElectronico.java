package co.com.sofka.challengeDDD.domain.utileria.commands;


import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EliminarInsumoElectronico extends Command {

    private final InsumoID insumoID;

}