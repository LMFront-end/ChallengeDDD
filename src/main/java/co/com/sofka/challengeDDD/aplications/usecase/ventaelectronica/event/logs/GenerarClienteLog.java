package co.com.sofka.challengeDDD.aplications.usecase.ventaelectronica.event.logs;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.ClienteId;

public interface GenerarClienteLog {
    Boolean generate(ClienteId clienteId, String log);
}
