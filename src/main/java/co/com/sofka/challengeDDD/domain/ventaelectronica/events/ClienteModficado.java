package co.com.sofka.challengeDDD.domain.ventaelectronica.events;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.ClienteId;
import co.com.sofka.challengeDDD.generics.Email;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ClienteModficado extends DomainEvent {

    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Email email;

    public ClienteModficado(ClienteId clienteId, Nombre nombre, Identificacion identificacion, Email email) {
        super("co.com.sofka.challengeDDD.ClienteModificado");
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
    }
}
