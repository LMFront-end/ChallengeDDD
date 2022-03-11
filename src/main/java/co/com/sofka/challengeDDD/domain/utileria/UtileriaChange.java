package co.com.sofka.challengeDDD.domain.utileria;

import co.com.sofka.challengeDDD.domain.show.events.ShowCreado;
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
        apply((ProductoAniadido event) -> {
            utileria.productos.add(new Producto(
                    event.getProductoID(),
                    event.getTipoProductoJuguete(),
                    event.getTipoProductoDisfraz(),
                    event.getEstadoProducto()
            ));
        });

        //  eliminarProducto()
        apply((ProductoEliminado event) ->{
            utileria.productos.forEach(producto -> {
                if (producto.identity().equals(event.getProductoID())) {
                    utileria.productos.remove(producto);
                }
            });
        });

        //  añadirInsumoElectronico()
        apply((InsumoElectronicoAniadido event) ->{
            utileria.insumosElectronicos.add(new InsumoElectronico(
                    event.getInsumoID(),
                    event.getTipoDeInsumo(),
                    event.getEstadoInsumo()
            ));
        });

        //  eliminarInsumoElectronico()
        apply((InsumoElectronicoEliminado event) -> {

        });

        // utilizarEspacio()
        apply((EspacioUtilizado event) ->{
        });

        // cambiarEspacio()
        apply((EspacioCambiado event) -> {

        });
    }
}
