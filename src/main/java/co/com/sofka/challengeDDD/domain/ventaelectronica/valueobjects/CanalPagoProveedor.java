package co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects;

import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.properties_values.CanalPagoProveedorValue;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CanalPagoProveedor implements ValueObject <CanalPagoProveedorValue>{

    // se crea la variable
    private final CanalPagoProveedorValue value;

    public CanalPagoProveedor(CanalPagoProveedorValue value) {
        this.value = value;
    }

    @Override
    public CanalPagoProveedorValue value() {
        return null;
    }

    // se implementa el equal y hashCode
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CanalPagoProveedor)) return false;
        CanalPagoProveedor that = (CanalPagoProveedor) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
