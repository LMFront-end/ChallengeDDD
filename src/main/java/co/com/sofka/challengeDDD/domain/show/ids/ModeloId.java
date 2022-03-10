package co.com.sofka.challengeDDD.domain.show.ids;

import co.com.sofka.domain.generic.Identity;

public class ModeloId extends Identity {

    // constructor

    public ModeloId(String uuid) {
        super(uuid);
    }

    public ModeloId() {
    }

    public static MonitorId of(String value){
        return new MonitorId(value);
    }
}
