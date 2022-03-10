package co.com.sofka.challengeDDD.generics;

import co.com.sofka.challengeDDD.generics.properties_values.NombreProperties;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<NombreProperties> {

    // declaracion de variable
    private final String nombre;
    private final String apellido;


    // constructor
    public Nombre(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public NombreProperties value() {
        return new NombreProperties() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }
        };
    }

    // implementación de equals y el hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nombre)) return false;
        Nombre nombre1 = (Nombre) o;
        return nombre.equals(nombre1.nombre) && apellido.equals(nombre1.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
