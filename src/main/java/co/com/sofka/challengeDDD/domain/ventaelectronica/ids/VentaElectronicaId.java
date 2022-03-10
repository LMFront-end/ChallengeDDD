package co.com.sofka.challengeDDD.domain.ventaelectronica.ids;

import co.com.sofka.domain.generic.Identity;

public class VentaElectronicaId extends Identity {

    // constructores

    public VentaElectronicaId(String uuid) {
        super(uuid);
    }

    public VentaElectronicaId() {
    }

    public static VentaElectronicaId of(String value){
        return new VentaElectronicaId(value);
    }
}
