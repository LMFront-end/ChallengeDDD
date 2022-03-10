package co.com.sofka.challengeDDD.domain.utileria.valueobjects;

import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.EstadoProductoValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoProducto implements ValueObject<EstadoProductoValue> {

    // se crea la variable
    private final EstadoProductoValue value;

    public EstadoProducto(EstadoProductoValue value) {
        this.value = value;
    }

    @Override
    public EstadoProductoValue value() {
        return value;
    }

    // se implementa el equal y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstadoProducto)) return false;
        EstadoProducto that = (EstadoProducto) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
