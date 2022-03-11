package co.com.sofka.challengeDDD.domain.ventaelectronica.events;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.ClienteId;
import co.com.sofka.challengeDDD.generics.Email;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;


@Getter
public class ClienteCreado extends DomainEvent {

    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Email email;

    public ClienteCreado(ClienteId clienteId, Nombre nombre, Identificacion identificacion, Email email) {
        super("co.com.sofka.challengeDDD.ClienteCreado");
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
    }
}
