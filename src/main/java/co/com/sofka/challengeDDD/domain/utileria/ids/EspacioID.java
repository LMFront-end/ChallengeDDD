package co.com.sofka.challengeDDD.domain.utileria.ids;

import co.com.sofka.domain.generic.Identity;

public class EspacioID extends Identity {

    // constructores

    public EspacioID(String uuid) {
        super(uuid);
    }

    public EspacioID() {
    }

    public static EspacioID of(String value){
        return new EspacioID(value);
    }
}
