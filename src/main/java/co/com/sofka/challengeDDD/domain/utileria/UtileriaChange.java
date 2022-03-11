package co.com.sofka.challengeDDD.domain.utileria;

import co.com.sofka.challengeDDD.domain.utileria.entities.Espacio;
import co.com.sofka.challengeDDD.domain.utileria.entities.InsumoElectronico;
import co.com.sofka.challengeDDD.domain.utileria.entities.Producto;
import co.com.sofka.challengeDDD.domain.utileria.events.*;
import co.com.sofka.domain.generic.EventChange;

public class UtileriaChange extends EventChange {

    public UtileriaChange(Utileria utileria) {

        apply((UtileriaCreada event) -> {
            utileria.utileriaID = event.getUtileriaID();
            utileria.showId = event.getShowId();
        });

        // Métodos

        //  añadirProducto()
        apply((ProductoAniadido event) -> utileria.productos.add(new Producto(
                event.getProductoID(),
                event.getTipoProductoJuguete(),
                event.getTipoProductoDisfraz(),
                event.getEstadoProducto()
        )));

        //  eliminarProducto()
        apply((ProductoEliminado event) -> utileria.productos.forEach(producto -> {
            if (producto.identity().equals(event.getProductoID())) {
                utileria.productos.remove(producto);
            }
        }));

        //  añadirInsumoElectronico()
        apply((InsumoElectronicoAniadido event) -> utileria.insumosElectronicos.add(new InsumoElectronico(
                event.getInsumoID(),
                event.getTipoDeInsumo(),
                event.getEstadoInsumo()
        )));

        //  eliminarInsumoElectronico()
        apply((InsumoElectronicoEliminado event) -> utileria.insumosElectronicos.forEach(insumo -> {
            if (insumo.identity().equals(event.getInsumoID())) {
                utileria.insumosElectronicos.remove(insumo);
            }
        }));

        // utilizarEspacio()
        apply((EspacioUtilizado event) -> utileria.espacio = new Espacio(
                event.getEntityId(),
                event.getTipoHabitacion(),
                event.getEstadoHabitacion()
        ));

        // cambiarEspacio()
        apply((EspacioCambiado event) -> {
            utileria.espacio.CambiarEstadoHabitacion(event.getEstadoHabitacion());
            utileria.espacio.cambiarTipoHabitacion(event.getTipoHabitacion());
        });
    }
}
