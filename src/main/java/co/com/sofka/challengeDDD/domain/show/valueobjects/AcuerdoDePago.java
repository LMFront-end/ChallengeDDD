package co.com.sofka.challengeDDD.domain.show.valueobjects;

import co.com.sofka.challengeDDD.domain.show.valueobjects.properties_values.AcuerdoDePagoProperties;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class AcuerdoDePago implements ValueObject<AcuerdoDePagoProperties> {

    // se crean variables
    private final Double acuerdo;

    // constructor
    public AcuerdoDePago(Double acuerdo) {
        this.acuerdo = acuerdo;
    }

    @Override
    public AcuerdoDePagoProperties value() {
        return new AcuerdoDePagoProperties() {

            @Override
            public Double acuerdo() {
                return acuerdo;
            }
        };
    }

    // se implementa el equal y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcuerdoDePago)) return false;
        AcuerdoDePago that = (AcuerdoDePago) o;
        return acuerdo.equals(that.acuerdo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acuerdo);
    }
}
