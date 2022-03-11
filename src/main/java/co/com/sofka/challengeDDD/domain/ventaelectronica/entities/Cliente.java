package co.com.sofka.challengeDDD.domain.ventaelectronica.entities;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.ClienteId;
import co.com.sofka.challengeDDD.generics.Email;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

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

    // métodos de la entidad Cliente

    // cambiarNombre()
    public void cambiarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    // cambiarIdentificacion()
    public void cambiarIdentificacion(Identificacion identificacion){
        this.identificacion = Objects.requireNonNull(identificacion);
    }

    // cambiarEmail()
    public void cambiarEmail(Email email){
        this.email = Objects.requireNonNull(email);
    }
}
