package co.com.sofka.challengeDDD.domain.show.valueobjects;

import co.com.sofka.challengeDDD.domain.show.valueobjects.properties_values.PaginaDeTransmisionValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PaginasDeTransmision implements ValueObject<PaginaDeTransmisionValue> {

    // se crean variables
    private final PaginaDeTransmisionValue value;

    // contructor
    public PaginasDeTransmision(PaginaDeTransmisionValue value) {
        this.value = value;
    }

    @Override
    public PaginaDeTransmisionValue value() {
        return value;
    }

    // se implementa el equal y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaginasDeTransmision)) return false;
        PaginasDeTransmision that = (PaginasDeTransmision) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
