package co.com.sofka.challengeDDD.domain.utileria.valueobjects;

import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.EstadoHabitacionValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoHabitacion implements ValueObject<EstadoHabitacionValue> {

    // se crea la variable
    private final EstadoHabitacionValue value;

    // se crea el constructor
    public EstadoHabitacion(EstadoHabitacionValue value) {
        this.value = value;
    }

    @Override
    public EstadoHabitacionValue value() {
        return value;
    }

    // se implementa el equal y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstadoHabitacion)) return false;
        EstadoHabitacion that = (EstadoHabitacion) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
