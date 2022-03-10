package co.com.sofka.challengeDDD.domain.utileria.valueobjects;

import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.EstadoInsumoValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoInsumo implements ValueObject<EstadoInsumoValue> {

    // se crea la variable
    private final EstadoInsumoValue value;

    // se crea el constructor
    public EstadoInsumo(EstadoInsumoValue value) {
        this.value = value;
    }

    @Override
    public EstadoInsumoValue value() {
        return value;
    }

    // se implementa el equal y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstadoInsumo)) return false;
        EstadoInsumo that = (EstadoInsumo) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
