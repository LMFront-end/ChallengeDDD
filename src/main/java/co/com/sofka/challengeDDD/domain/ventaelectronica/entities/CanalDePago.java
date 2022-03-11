package co.com.sofka.challengeDDD.domain.ventaelectronica.entities;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.CanalDePagoId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.CanalPagoProveedor;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.PoliticaDeRetiro;
import co.com.sofka.domain.generic.Entity;

public class CanalDePago extends Entity<CanalDePagoId> {

    // se crean variables para los objectValue

    private CanalPagoProveedor canalPagoProveedor;
    private PoliticaDeRetiro politicaDeRetiro;

    // se crea constructor para los objectValue

    public CanalDePago(CanalDePagoId entityId, CanalPagoProveedor canalPagoProveedor, PoliticaDeRetiro politicaDeRetiro) {
        super(entityId);
        this.canalPagoProveedor = canalPagoProveedor;
        this.politicaDeRetiro = politicaDeRetiro;
    }

    //
}
