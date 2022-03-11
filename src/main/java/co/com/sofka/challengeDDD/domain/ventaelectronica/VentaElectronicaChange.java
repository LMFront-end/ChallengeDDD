package co.com.sofka.challengeDDD.domain.ventaelectronica;
import co.com.sofka.challengeDDD.domain.utileria.events.*;
import co.com.sofka.challengeDDD.domain.ventaelectronica.entities.Transaccion;
import co.com.sofka.challengeDDD.domain.ventaelectronica.events.*;
import co.com.sofka.domain.generic.EventChange;

public class VentaElectronicaChange extends EventChange {

    public VentaElectronicaChange(VentaElectronica ventaElectronica){

        apply((VentaElectronicaCreada event) -> {
            ventaElectronica.ventaElectronicaId = event.getVentaElectronicaId();
            ventaElectronica.showId = event.getShowId();
        });

        // Métodos

        // crearTransaccion()
        apply((TransaccionCreada event) ->{
            ventaElectronica.transaccion = new Transaccion(
              event.getTransaccionId(),
              event.getValorMoneda(),
              event.getFecha()
            );
        });

        // modificarTransaccion()
        apply((TransaccionModificada event) ->{
            ventaElectronica.transaccion.cambiarFecha(event.getFecha());
            ventaElectronica.transaccion.cambiarValorMoneda(event.getValorMoneda());
        });

        // crearCliente()
        apply((ClienteCreado event) ->{
        });

        // modificarCliente()
        apply((ClienteModificado event) ->{
        });

        // crearCanalDePago()
        apply((CanalDePagoCreado event) ->{
        });

        // modificarCanalDePago()

        apply((CanalDePagoModificado event) ->{
        });
    }

}
