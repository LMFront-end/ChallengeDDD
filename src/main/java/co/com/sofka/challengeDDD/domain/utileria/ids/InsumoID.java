package co.com.sofka.challengeDDD.domain.utileria.ids;

import co.com.sofka.domain.generic.Identity;

public class InsumoID extends Identity {

    // constructores

    public InsumoID(String uuid) {
        super(uuid);
    }

    public InsumoID() {
    }

    public static InsumoID of(String value){
        return new InsumoID(value);
    }
}
