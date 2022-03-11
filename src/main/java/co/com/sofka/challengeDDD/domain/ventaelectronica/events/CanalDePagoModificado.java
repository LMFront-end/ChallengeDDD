package co.com.sofka.challengeDDD.domain.ventaelectronica.events;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.CanalDePagoId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.CanalPagoProveedor;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.PoliticaDeRetiro;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CanalDePagoModificado extends DomainEvent {

    private final CanalDePagoId canalDePagoId;
    private final CanalPagoProveedor canalPagoProveedor;
    private final PoliticaDeRetiro politicaDeRetiro;

    public CanalDePagoModificado(CanalDePagoId canalDePagoId, CanalPagoProveedor canalPagoProveedor, PoliticaDeRetiro politicaDeRetiro) {
        super("co.com.sofka.challengeDDD.CanalDePagoModificado");
        this.canalDePagoId = canalDePagoId;
        this.canalPagoProveedor = canalPagoProveedor;
        this.politicaDeRetiro = politicaDeRetiro;
    }
}
