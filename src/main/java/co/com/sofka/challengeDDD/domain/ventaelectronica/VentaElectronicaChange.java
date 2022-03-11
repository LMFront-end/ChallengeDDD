package co.com.sofka.challengeDDD.domain.ventaelectronica;

import co.com.sofka.challengeDDD.domain.utileria.events.UtileriaCreada;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.VentaElectronicaCreada;
import co.com.sofka.domain.generic.EventChange;

public class VentaElectronicaChange extends EventChange {

    public VentaElectronicaChange(VentaElectronica ventaElectronica){

        apply((VentaElectronicaCreada event) -> {
            ventaElectronica.ventaElectronicaId = event.getVentaElectronicaId();
            ventaElectronica.showId = event.getShowId();
        });

        // Métodos

        // crearTransaccion()

        // modificarTransaccion()

        // crearCliente()

        // modificarCliente()

        // crearCanalDePago()

        // modificarCanalDePago()

        
    }

}
