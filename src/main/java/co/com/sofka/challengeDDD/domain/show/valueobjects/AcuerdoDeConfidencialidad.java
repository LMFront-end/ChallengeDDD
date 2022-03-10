package co.com.sofka.challengeDDD.domain.show.valueobjects;

import co.com.sofka.challengeDDD.domain.show.valueobjects.properties_values.AcuerdoDeConfidencialidadValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class AcuerdoDeConfidencialidad implements ValueObject<AcuerdoDeConfidencialidadValue> {

    // se crea la variable
    private final AcuerdoDeConfidencialidadValue value;

    // se crea el constructor
    public AcuerdoDeConfidencialidad(AcuerdoDeConfidencialidadValue value) {
        this.value = value;
    }

    @Override
    public AcuerdoDeConfidencialidadValue value() {
        return value;
    }

    // se implementa el equal y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcuerdoDeConfidencialidad)) return false;
        AcuerdoDeConfidencialidad that = (AcuerdoDeConfidencialidad) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
