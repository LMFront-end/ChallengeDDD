package co.com.sofka.challengeDDD.domain.utileria.valueobjects;

import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.TipoHabitacionValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoHabitacion implements ValueObject<TipoHabitacionValue> {

    // se crea la variable
    private final TipoHabitacionValue value;

    public TipoHabitacion(TipoHabitacionValue value) {
        this.value = value;
    }

    @Override
    public TipoHabitacionValue value() {
        return value;
    }

    // se implementa el equal y hashCode
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoHabitacion)) return false;
        TipoHabitacion that = (TipoHabitacion) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
