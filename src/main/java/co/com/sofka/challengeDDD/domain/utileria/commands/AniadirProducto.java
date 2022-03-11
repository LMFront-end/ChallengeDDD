package co.com.sofka.challengeDDD.domain.utileria.commands;

import co.com.sofka.challengeDDD.domain.show.ids.ShowId;
import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;
import co.com.sofka.challengeDDD.domain.utileria.ids.UtileriaID;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.EstadoProducto;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoDisfraz;
import co.com.sofka.challengeDDD.domain.utileria.valueobjects.TipoProductoJuguete;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AniadirProducto extends Command {

    private final ShowId showId;
    private final UtileriaID utileriaID;
    private final ProductoID productoID;
    private final TipoProductoJuguete tipoProductoJuguete;
    private final TipoProductoDisfraz tipoProductoDisfraz;
    private final EstadoProducto estadoProducto;

}
