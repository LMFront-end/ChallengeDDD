package co.com.sofka.challengeDDD.domain.show.entities;

import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;
import co.com.sofka.challengeDDD.domain.generics.Email;
import co.com.sofka.challengeDDD.domain.generics.Identificacion;
import co.com.sofka.challengeDDD.domain.generics.Nombre;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Modelo extends Entity<ModeloId> {

    // se crean variables para los objectValues

    private Nombre nombre;
    private Identificacion identificacion;
    private Email email;

    // se crea constructor para los objectValue
    public Modelo(ModeloId modeloId, Nombre nombre, Identificacion identificacion, Email email){

        // super --> herencia
        super(modeloId);
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
    }

        // métodos de la entidad Modelo

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
