package co.com.sofka.challengeDDD.domain.show.ids;

import co.com.sofka.domain.generic.Identity;

public class CanalDeTransmisionId extends Identity {

    // contructores
    public CanalDeTransmisionId(String uuid) {
        super(uuid);
    }

    public CanalDeTransmisionId() {
    }

    public static CanalDeTransmisionId of(String value){
        return new CanalDeTransmisionId(value);
    }
}
