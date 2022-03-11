package co.com.sofka.challengeDDD.domain.show.commands;
import co.com.sofka.challengeDDD.domain.show.ids.ModeloId;
import co.com.sofka.challengeDDD.generics.Email;
import co.com.sofka.challengeDDD.generics.Identificacion;
import co.com.sofka.challengeDDD.generics.Nombre;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;

@Getter
public class CambiarModelo extends Command{
    
    private final ModeloId modeloId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Email email;

    public CambiarModelo(ModeloId modeloId, Nombre nombre, Identificacion identificacion, Email email) {
        this.modeloId = modeloId;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        }
    

}
