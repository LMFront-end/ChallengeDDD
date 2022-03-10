package co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects;

import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.properties_values.PoliticaDeRetiroValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PoliticaDeRetiro implements ValueObject<PoliticaDeRetiroValue> {

    // Declaración de variable
    private final PoliticaDeRetiroValue value;

    public PoliticaDeRetiro(PoliticaDeRetiroValue value) {
        this.value = value;
    }

    @Override
    public PoliticaDeRetiroValue value() {
        return value;
    }

    // se implementa el equal y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PoliticaDeRetiro)) return false;
        PoliticaDeRetiro that = (PoliticaDeRetiro) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
