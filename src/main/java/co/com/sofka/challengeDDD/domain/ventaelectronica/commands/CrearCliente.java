package co.com.sofka.challengeDDD.domain.ventaelectronica.commands;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.ClienteId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;
import co.com.sofka.challengeDDD.domain.generics.Email;
import co.com.sofka.challengeDDD.domain.generics.Identificacion;
import co.com.sofka.challengeDDD.domain.generics.Nombre;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CrearCliente extends Command {

    private final ShowId showId;
    private final VentaElectronicaId ventaElectronicaId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Email email;

}
