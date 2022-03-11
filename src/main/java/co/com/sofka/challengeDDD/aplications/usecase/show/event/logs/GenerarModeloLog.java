package co.com.sofka.challengeDDD.aplications.usecase.show.event.logs;

import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;

public interface GenerarModeloLog {
    Boolean generate(ModeloId modeloId, String log);
}
