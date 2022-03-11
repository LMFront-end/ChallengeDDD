package co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs;

import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;

public interface GenerarInsumoElectronicoLog {
    Boolean generate(InsumoID insumoID, String log);
}
