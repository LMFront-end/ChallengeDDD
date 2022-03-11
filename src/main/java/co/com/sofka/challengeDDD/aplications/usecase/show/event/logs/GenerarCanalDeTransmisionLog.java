package co.com.sofka.challengeDDD.aplications.usecase.show.event.logs;

import co.com.sofka.challengeDDD.domain.show.ids.CanalDeTransmisionId;

public interface GenerarCanalDeTransmisionLog {
    Boolean generate(CanalDeTransmisionId canalDeTransmisionId, String log);
}
