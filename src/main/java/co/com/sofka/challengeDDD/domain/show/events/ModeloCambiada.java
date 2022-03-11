package co.com.sofka.challengeDDD.domain.show.events;

import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;
import co.com.sofka.challengeDDD.generics.Email;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;


@Getter
public class ModeloCambiada extends DomainEvent {

    private final ModeloId modeloId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Email email;

    public ModeloCambiada(ModeloId modeloId, Nombre nombre, Identificacion identificacion, Email email) {
        super("co.com.sofka.challengeDDD.ModeloCambiada");
        this.modeloId = modeloId;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
    }
}
