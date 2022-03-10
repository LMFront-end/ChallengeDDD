package co.com.sofka.challengeDDD.domain.utileria.entities;

import co.com.sofka.challengeDDD.domain.utileria.ids.InsumoID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoInsumo;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoDeInsumo;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class InsumoElectronico extends Entity<InsumoID> {

    // se crean variables para los objectValue

    private TipoDeInsumo tipoDeInsumo;
    private EstadoInsumo estadoInsumo;

    // se crea constructor para los objectValue


    public InsumoElectronico(InsumoID entityId, TipoDeInsumo tipoDeInsumo, EstadoInsumo estadoInsumo) {
        super(entityId);
        this.tipoDeInsumo = tipoDeInsumo;
        this.estadoInsumo = estadoInsumo;
    }

    // métodos de la entidad InsumoElectronico

    // cambiarTipoInsumo()
    public void cambiarTipoInsumo(TipoDeInsumo tipoDeInsumo){
        this.tipoDeInsumo = Objects.requireNonNull(tipoDeInsumo);
    }

    // cambiarEstadoInsumo()
    public void cambiarEstadoInsumo(EstadoInsumo estadoInsumo){
        this.estadoInsumo = Objects.requireNonNull(estadoInsumo);
    }
}
