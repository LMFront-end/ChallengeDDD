package co.com.sofka.challengeDDD.domain.ventaelectronica.entities;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.TransaccionId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.Fecha;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.ValorMoneda;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Transaccion extends Entity <TransaccionId> {

    // se crean variables para los objectValue

    private ValorMoneda valorMoneda;
    private Fecha fecha;

    // se crea constructor para los objectValue

    public Transaccion(TransaccionId entityId, ValorMoneda valorMoneda, Fecha fecha) {
        super(entityId);
        this.valorMoneda = valorMoneda;
        this.fecha = fecha;
    }

    // métodos de la entidad Transacción

    // cambiarFecha()
    public void cambiarFecha(Fecha fecha) {
        this.fecha = Objects.requireNonNull(fecha);
    }

    // cambiarValorMoneda()
    public void cambiarValorMoneda(ValorMoneda valorMoneda) {
        this.valorMoneda = Objects.requireNonNull(valorMoneda);
    }

}
