package co.com.sofka.challengeDDD.domain.utileria.valueobjects;

import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.TipoProductoJugueteValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoProductoJuguete implements ValueObject<TipoProductoJugueteValue> {

    // se crea la variable
    private final TipoProductoJugueteValue value;

    public TipoProductoJuguete(TipoProductoJugueteValue value) {
        this.value = value;
    }

    @Override
    public TipoProductoJugueteValue value() {
        return value;
    }

    // se implementa el equal y hashCode
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoProductoJuguete)) return false;
        TipoProductoJuguete that = (TipoProductoJuguete) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
