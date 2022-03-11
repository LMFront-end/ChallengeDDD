package co.com.sofka.challengeDDD.domain.utileria;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.entities.Espacio;
import co.com.sofka.challengeDDD.domain.utileria.entities.InsumoElectronico;
import co.com.sofka.challengeDDD.domain.utileria.entities.Producto;
import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoProducto;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoDisfraz;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoJuguete;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Utileria extends AggregateEvent<UtileriaID> {

    /*
     * evento --> pasado
     * comando --> presente
     * */

    // se llama a las entidades de Utileria

    // referencia a show
    protected ShowId showId;

    protected UtileriaID utileriaID;
    protected Espacio espacio;
    protected Set<InsumoElectronico> insumosElectronicos;
    protected Set<Producto> productos;


    // se crea el constructor
    public Utileria(UtileriaID entityId, ShowId showId) {
        super(entityId);
        // se llama a los comportamientos del agregado
        appendChange(new UtileriaCreada(entityId, showId)).apply();

        subscribe(new UtileriaChange(this));
    }

    // se crea la función from para utileria
    // Método que permite reconstruir el estado del agregado a partir de una lista de eventos de dominios
    public static Utileria from(UtileriaID utileriaID, ShowId showId, List<DomainEvent> events){

        var utileria = new Utileria(utileriaID, showId);

        // Evento de dominio, aplica el evento de dominio sobre el show
        //events.forEach(event -> show.applyEvent(event))
        events.forEach(utileria::applyEvent);

        return utileria;
    }

    // métodos del agregado [AR]Utileria

    // añadirProducto()
    public void aniadirProducto(ProductoID productoId, TipoProductoJuguete tipoProductoJuguete, TipoProductoDisfraz tipoProductoDisfraz, EstadoProducto estadoProducto){
        Objects.requireNonNull(productoId);
        Objects.requireNonNull(tipoProductoJuguete);
        Objects.requireNonNull(tipoProductoDisfraz);
        Objects.requireNonNull(estadoProducto);
        appendChange(new ProductoAniadido(productoId, tipoProductoDisfraz, tipoProductoJuguete, estadoProducto)).apply();
    }

    // eliminarProducto()

    // añadirInsumoElectronico()

    // eliminarInsumoElectronico()

    // utilizarEspacio()

    // cambiarEspacio()



}
