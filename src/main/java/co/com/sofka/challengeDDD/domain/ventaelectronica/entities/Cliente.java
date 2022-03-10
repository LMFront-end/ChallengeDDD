package co.com.sofka.challengeDDD.domain.ventaelectronica.entities;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.ClienteId;
import co.com.sofka.challengeDDD.generics.Email;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Cliente extends Entity<ClienteId> {

    // se crean las variables para los objectValue

    private Nombre nombre;
    private Identificacion identificacion;
    private Email email;

    // se crea constructor para los objectValue


    public Cliente(ClienteId entityId, Nombre nombre, Identificacion identificacion, Email email) {
        super(entityId);
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
    }
}
