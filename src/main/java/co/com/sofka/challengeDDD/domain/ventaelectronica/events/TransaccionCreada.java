package co.com.sofka.challengeDDD.domain.ventaelectronica.events;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.TransaccionId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.Fecha;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.ValorMoneda;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter
public class TransaccionCreada extends DomainEvent {

    private final TransaccionId transaccionId;
    private final ValorMoneda valorMoneda;
    private final Fecha fecha;

    public TransaccionCreada(TransaccionId transaccionId, ValorMoneda valorMoneda, Fecha fecha) {
        super("co.com.sofka.challengeDDD.TransaccionCreada");
        this.transaccionId = transaccionId;
        this.valorMoneda = valorMoneda;
        this.fecha = fecha;
    }
}
