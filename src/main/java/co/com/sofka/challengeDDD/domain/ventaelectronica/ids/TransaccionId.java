package co.com.sofka.challengeDDD.domain.ventaelectronica.ids;

import co.com.sofka.domain.generic.Identity;

public class TransaccionId extends Identity {

    // constructores

    public TransaccionId(String uuid) {
        super(uuid);
    }

    public TransaccionId() {
    }

    public static TransaccionId of(String value){
        return new TransaccionId(value);
    }
}
