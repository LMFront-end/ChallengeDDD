package co.com.sofka.challengeDDD.domain.utileria.commands;

import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EliminarProducto extends Command {

    private final ProductoID productoID;

}
