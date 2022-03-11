package co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs;

import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;

public interface GenerarUtileriaLog {
    Boolean generate(UtileriaID utileriaID, String log);
}
