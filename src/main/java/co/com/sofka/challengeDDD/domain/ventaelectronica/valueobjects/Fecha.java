package co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects;

import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.properties_values.FechaProperties;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Fecha implements ValueObject<FechaProperties> {

    // Declaración de variable
    private final Date fecha;

    public Fecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public FechaProperties value() {
        return new FechaProperties() {

            @Override
            public Date fecha() {
                return fecha;
            }
        };
    }

    // implementación de equals y el hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fecha)) return false;
        Fecha fecha1 = (Fecha) o;
        return fecha.equals(fecha1.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }
}
