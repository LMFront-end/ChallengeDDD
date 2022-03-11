package co.com.sofka.challengeDDD.domain.ventaelectronica;


import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.Utileria;
import co.com.sofka.challengeDDD.domain.utileria.UtileriaChange;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.challengeDDD.domain.ventaelectronica.entities.CanalDePago;
import co.com.sofka.challengeDDD.domain.ventaelectronica.entities.Cliente;
import co.com.sofka.challengeDDD.domain.ventaelectronica.entities.Transaccion;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.TransaccionId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.Fecha;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.ValorMoneda;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class VentaElectronica extends AggregateEvent<VentaElectronicaId> {

    /*
     * evento --> pasado
     * comando --> presente
     * */

    // se llama a las entidades de Utileria
    // referencia a show
    protected ShowId showId;

    protected VentaElectronicaId ventaElectronicaId;
    protected Cliente cliente;
    protected CanalDePago canalDePago;
    protected Transaccion transaccion;


    // se crea el constructor
    public VentaElectronica(VentaElectronicaId entityId, ShowId showId) {
        super(entityId);
        // se llama a los comportamientos del agregado
        appendChange(new VentaElectronicaCreada(entityId, showId)).apply();

        subscribe(new VentaElectronicaChange(this));
    }

    // se crea la función from para utileria
    // Método que permite reconstruir el estado del agregado a partir de una lista de eventos de dominios
    public static VentaElectronica from(VentaElectronicaId entityId, ShowId showId, List<DomainEvent> events){

        var ventaElectronica = new VentaElectronica(entityId, showId);

        // Evento de dominio, aplica el evento de dominio sobre el show
        //events.forEach(event -> show.applyEvent(event))
        events.forEach(ventaElectronica::applyEvent);

        return ventaElectronica;
    }

    // métodos del agregado [AR] VentaElectronica


    // crearTransaccion()
    public void crearTransaccion(TransaccionId entityId, ValorMoneda valorMoneda, Fecha fecha){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(valorMoneda);
        Objects.requireNonNull(fecha);
        appendChange(new TransaccionCreada(entityId, valorMoneda, fecha)).apply();
    }

    // modificarTransaccion()
    public void modificarTransaccion(){

    }

    // crearCliente()
    public void crearCliente(){

    }

    // modificarCliente()
    public void modificarCliente(){

    }

    // crearCanalDePago()
    public void crearCanalDePago(){

    }

    // modificarCanalDePago()
    public void modificarCanalDePago(){

    }
}
