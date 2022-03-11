package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event.logs;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;

public interface GenerarVentaElectronicaLog {
    Boolean generate(VentaElectronicaId ventaElectronicaId, String log);
}
