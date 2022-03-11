package co.com.sofka.challengeDDD.domain.utileria.events;

import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoProducto;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoDisfraz;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoJuguete;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;



@Getter
public class ProductoEliminado extends DomainEvent {

    private final ProductoID productoID;

    public ProductoEliminado(ProductoID productoID) {
        super("co.com.sofka.challengeDDD.ProductoEliminado");
        this.productoID = productoID;
        
    }
}
