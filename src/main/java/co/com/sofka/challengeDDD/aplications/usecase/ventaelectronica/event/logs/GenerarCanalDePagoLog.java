package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event.logs;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.CanalDePagoId;

public interface GenerarCanalDePagoLog {
    Boolean generate(CanalDePagoId canalDePagoId, String log);
}
