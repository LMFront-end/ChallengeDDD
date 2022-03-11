package co.com.sofka.challengeDDD.domain.utileria.events;

import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoProducto;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoDisfraz;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoJuguete;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;


@Getter
public class ProductoAniadido extends DomainEvent {

    private final ProductoID productoID;
    private final TipoProductoJuguete tipoProductoJuguete;
    private final TipoProductoDisfraz tipoProductoDisfraz;
    private final EstadoProducto estadoProducto;

    public ProductoAniadido(ProductoID productoID, TipoProductoDisfraz tipoProductoJuguete, TipoProductoJuguete tipoProductoDisfraz, EstadoProducto estadoProducto) {
        super("co.com.sofka.challengeDDD.ProductoAniadido");
        this.productoID = productoID;
        this.tipoProductoJuguete = tipoProductoJuguete;
        this.tipoProductoDisfraz = tipoProductoDisfraz;
        this.estadoProducto = estadoProducto;
    }
}
