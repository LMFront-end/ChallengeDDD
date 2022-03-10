package co.com.sofka.challengeDDD.domain.utileria.entities;

import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoProducto;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoDisfraz;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoJuguete;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Producto extends Entity<ProductoID> {

    // se crean variables para los objectValue

    private TipoProductoJuguete tipoProductoJuguete;
    private TipoProductoDisfraz tipoProductoDisfraz;
    private EstadoProducto estadoProducto;

    // se crea constructor para los objectValue
    public Producto(ProductoID productoId, TipoProductoJuguete tipoProductoJuguete, TipoProductoDisfraz tipoProductoDisfraz, EstadoProducto estadoProducto ){

        // Super --> Herencia
        super(productoId);
        this.estadoProducto = estadoProducto;
        this.tipoProductoDisfraz = tipoProductoDisfraz;
        this.tipoProductoJuguete = tipoProductoJuguete;

    }

    // métodos de la entidad CanalDeTransmisión

    // CambiarTipoProductoJuguete()
    public void cambiarTipoProductoJuguete(TipoProductoJuguete tipoProductoJuguete){
        this.tipoProductoJuguete = Objects.requireNonNull(tipoProductoJuguete);
    }

    // CambiarTipoProductoDisfraz()
    public void cambiarTipoProductoDisfraz(TipoProductoDisfraz tipoProductoDisfraz){
        this.tipoProductoDisfraz = Objects.requireNonNull(tipoProductoDisfraz);
    }

    // CambiarEstadoProducto()
    public void cambiarEstadoProducto(EstadoProducto estadoProducto){
        this.estadoProducto = Objects.requireNonNull(estadoProducto);
    }
}
