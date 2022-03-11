package co.com.sofka.challengeDDD.aplications.usecase.utileria.event.logs;

import co.com.sofka.challengeDDD.domain.utileria.ids.ProductoID;

public interface GenerarProductoLog {
    Boolean generate(ProductoID productoID, String log);
}
