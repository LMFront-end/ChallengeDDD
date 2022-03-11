package co.com.sofka.challengeDDD.domain.ventaelectronica.events;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.CanalDePagoId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.CanalPagoProveedor;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.PoliticaDeRetiro;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter
public class CanalDePagoCreado extends DomainEvent {

    private final CanalDePagoId canalDePagoId;
    private final CanalPagoProveedor canalPagoProveedor;
    private final PoliticaDeRetiro politicaDeRetiro;

    public CanalDePagoCreado(CanalDePagoId canalDePagoId, CanalPagoProveedor canalPagoProveedor, PoliticaDeRetiro politicaDeRetiro) {
        super("co.com.sofka.challengeDDD.CanalDePagoCreado");
        this.canalDePagoId = canalDePagoId;
        this.canalPagoProveedor = canalPagoProveedor;
        this.politicaDeRetiro = politicaDeRetiro;
    }
}
