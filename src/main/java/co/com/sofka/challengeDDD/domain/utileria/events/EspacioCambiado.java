package co.com.sofka.challengeDDD.domain.utileria.events;

import co.com.sofka.challengeDDD.domain.utileria.ids.EspacioID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoHabitacion;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoHabitacion;
import co.com.sofka.domain.generic.DomainEvent;
import lombok.Getter;

@Getter
public class EspacioCambiado extends DomainEvent {

    private final EspacioID entityId;
    private final TipoHabitacion tipoHabitacion;
    private final EstadoHabitacion estadoHabitacion;

    public EspacioCambiado(EspacioID entityId, TipoHabitacion tipoHabitacion, EstadoHabitacion estadoHabitacion){
        super("co.com.sofka.challengeDDD.EspacioCambiado");
        this.entityId = entityId;
        this.estadoHabitacion = estadoHabitacion;
        this.tipoHabitacion = tipoHabitacion;
    }
}
