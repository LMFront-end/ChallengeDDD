package co.com.sofka.challengeDDD.domain.ventaelectronica.ids;

import co.com.sofka.domain.generic.Identity;

public class CanalDePagoId extends Identity {

    // constructores

    public CanalDePagoId(String uuid) {
        super(uuid);
    }

    public CanalDePagoId() {
    }

    public static CanalDePagoId of(String value){
        return new CanalDePagoId(value);
    }
}
