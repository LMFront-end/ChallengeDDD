package co.com.sofka.challengeDDD.aplications.usecase.show.event.logs;

import co.com.sofka.challengeDDD.domain.show.ids.MonitorId;

public interface GenerarMonitorLog {
    Boolean generate(MonitorId monitorId, String log);
}
