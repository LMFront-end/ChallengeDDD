package co.com.sofka.challengeDDD.domain.utileria.entities;

import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoProducto;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoDisfraz;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoJuguete;
import co.com.sofka.domain.generic.Entity;

public class Producto extends Entity<ProductoID> {

    // se crean variables para los objectValue

    private TipoProductoJuguete tipoProductoJuguete;
    private TipoProductoDisfraz tipoProductoDisfraz;
    private EstadoProducto estadoProducto;

    // se crea constructor para los objectValue
    public Producto(ProductoID productoId, TipoProductoJuguete tipoProductoJuguete, TipoProductoDisfraz tipoProductoDisfraz ){

        // Super --> Herencia
        super(productoId);
    }
}
