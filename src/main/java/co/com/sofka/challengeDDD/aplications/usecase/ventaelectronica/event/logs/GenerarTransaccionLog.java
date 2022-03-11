package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event.logs;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.TransaccionId;

public interface GenerarTransaccionLog {
    Boolean generate(TransaccionId transaccionId, String log);
}
