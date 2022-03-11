package co.com.sofka.challengeDDD.domain.generics;

import co.com.sofka.challengeDDD.domain.generics.properties_values.IdentificacionProperties;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Identificacion implements ValueObject<IdentificacionProperties> {

    // declaración de variables
    private final String identificacion;

    // constructor
    public Identificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public IdentificacionProperties value() {
        return new IdentificacionProperties(){

            @Override
            public String identificacion() {
                return identificacion;
            }
        };
    }

    // implementación de equals y el hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identificacion)) return false;
        Identificacion that = (Identificacion) o;
        return identificacion.equals(that.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion);
    }
}
