package co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs;

import co.com.sofka.challengeDDD.domain.utileria.ids.EspacioID;

public interface GenerarEspacioLog {
    Boolean generate(EspacioID espacioID, String log);
}
