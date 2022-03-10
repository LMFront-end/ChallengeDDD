package co.com.sofka.challengeDDD.domain.show.entities;

import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;
import co.com.sofka.challengeDDD.generics.Email;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Modelo extends Entity<ModeloId> {

    // se crean variables para los objectValues

    private Nombre nombre;
    private Identificacion identificacion;
    private Email email;

    // se crea constructor para los objectValue
    public Modelo(ModeloId modeloId, Nombre nombre, Identificacion identificacion, Email email){

        // super --> herencia
        super(modeloId);
    }

}
