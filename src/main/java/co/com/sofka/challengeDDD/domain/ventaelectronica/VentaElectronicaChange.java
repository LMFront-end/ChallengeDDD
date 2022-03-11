package co.com.sofka.challengeDDD.domain.ventaelectronica;
import co.com.sofka.challengeDDD.domain.utileria.events.*;
import co.com.sofka.challengeDDD.domain.ventaelectronica.entities.CanalDePago;
import co.com.sofka.challengeDDD.domain.ventaelectronica.entities.Cliente;
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
            ventaElectronica.cliente = new Cliente(
                    event.getClienteId(),
                    event.getNombre(),
                    event.getIdentificacion(),
                    event.getEmail()
            );
        });

        // modificarCliente()
        apply((ClienteModificado event) ->{
            ventaElectronica.cliente.cambiarNombre(event.getNombre());
            ventaElectronica.cliente.cambiarIdentificacion(event.getIdentificacion());
            ventaElectronica.cliente.cambiarEmail(event.getEmail());
        });

        // crearCanalDePago()
        apply((CanalDePagoCreado event) ->{
            ventaElectronica.canalDePago = new CanalDePago(
                    event.getCanalDePagoId(),
                    event.getCanalPagoProveedor(),
                    event.getPoliticaDeRetiro()
            );
        });

        // modificarCanalDePago()
        apply((CanalDePagoModificado event) ->{
            ventaElectronica.canalDePago.cambiarCanalPagoProveedor(event.getCanalPagoProveedor());
            ventaElectronica.canalDePago.cambiarPoliticaDeRetiro(event.getPoliticaDeRetiro());
        });
    }

}
