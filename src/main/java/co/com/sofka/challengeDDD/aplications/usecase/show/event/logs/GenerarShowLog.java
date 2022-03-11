package co.com.sofka.challengeDDD.aplications.usecase.show.event.logs;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;

public interface GenerarShowLog {
    Boolean generate(ShowId showId, String log);
}

