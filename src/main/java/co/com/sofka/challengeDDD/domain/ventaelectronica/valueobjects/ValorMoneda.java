package co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects;

import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.properties_values.ValorMonedaProperties;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorMoneda implements ValueObject<ValorMonedaProperties> {

    // Declaración de variable
    private final Double valorMoneda;

    public ValorMoneda(Double valorMoneda) {
        this.valorMoneda = valorMoneda;
    }

    @Override
    public ValorMonedaProperties value() {
        return new ValorMonedaProperties() {
            @Override
            public Double valorMoneda() {
                return valorMoneda;
            }
        };
    }

    // se implementa el equal y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValorMoneda)) return false;
        ValorMoneda that = (ValorMoneda) o;
        return valorMoneda.equals(that.valorMoneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorMoneda);
    }
}
