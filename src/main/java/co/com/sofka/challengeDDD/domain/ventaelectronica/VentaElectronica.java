package co.com.sofka.challengeDDD.domain.ventaelectronica;


import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.UtileriaChange;
import co.com.sofka.challengeDDD.domain.ventaelectronica.entities.CanalDePago;
import co.com.sofka.challengeDDD.domain.ventaelectronica.entities.Cliente;
import co.com.sofka.challengeDDD.domain.ventaelectronica.entities.Transaccion;
import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.VentaElectronicaId;
import co.com.sofka.domain.generic.AggregateEvent;

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
}
