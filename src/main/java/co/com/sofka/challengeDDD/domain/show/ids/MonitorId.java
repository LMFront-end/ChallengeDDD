package co.com.sofka.challengeDDD.domain.show.ids;

import co.com.sofka.domain.generic.Identity;

public class MonitorId extends Identity {

    // contructores
    public MonitorId(String uuid) {
        super(uuid);
    }

    public MonitorId() {
    }

    public static MonitorId of(String value){
        return new MonitorId(value);
    }
}
