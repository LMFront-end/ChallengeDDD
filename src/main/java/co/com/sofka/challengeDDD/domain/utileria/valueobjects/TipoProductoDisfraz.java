package co.com.sofka.challengeDDD.domain.utileria.valueobjects;

import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.TipoProductoDisfrazValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoProductoDisfraz implements ValueObject<TipoProductoDisfrazValue> {

    // se crea la variable
    private final TipoProductoDisfrazValue value;

    public TipoProductoDisfraz(TipoProductoDisfrazValue value) {
        this.value = value;
    }

    @Override
    public TipoProductoDisfrazValue value() {
        return value;
    }

    // se implementa el equal y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoProductoDisfraz)) return false;
        TipoProductoDisfraz that = (TipoProductoDisfraz) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
