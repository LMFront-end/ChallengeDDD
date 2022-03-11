package co.com.sofka.challengeDDD.domain.show.commands;
import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;
import co.com.sofka.challengeDDD.generics.Email;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AsignarModelo extends Command{

    private final ModeloId modeloId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Email email;

}
