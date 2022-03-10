package co.com.sofka.challengeDDD.domain.utileria.ids;

import co.com.sofka.domain.generic.Identity;

public class UtileriaID extends Identity {

    // constrctores

    public UtileriaID(String uuid) {
        super(uuid);
    }

    public UtileriaID() {
    }

    public static UtileriaID of(String value) {
        return new UtileriaID(value);
    }
}
