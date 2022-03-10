package co.com.sofka.challengeDDD.domain.ventaelectronica.ids;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {

    // constructores

    public ClienteId(String uuid) {
        super(uuid);
    }

    public ClienteId() {
    }

    public static ClienteId of(String value){
        return new ClienteId(value);
    }
}
