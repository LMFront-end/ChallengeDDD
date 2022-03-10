package co.com.sofka.challengeDDD.domain.utileria.valueobjects;

import co.com.sofka.challengeDDD.domain.utileria.valueobjects.properties_values.TipoDeInsumoValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeInsumo implements ValueObject<TipoDeInsumoValue> {

    // se crea la variable
    private final TipoDeInsumoValue value;

    public TipoDeInsumo(TipoDeInsumoValue value) {
        this.value = value;
    }

    @Override
    public TipoDeInsumoValue value() {
        return value;
    }

    // se implementa el equal y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDeInsumo)) return false;
        TipoDeInsumo that = (TipoDeInsumo) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
