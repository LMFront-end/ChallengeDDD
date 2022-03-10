package co.com.sofka.challengeDDD.domain.utileria.ids;

import co.com.sofka.domain.generic.Identity;

public class ProductoID extends Identity {

    // Constructores

    public ProductoID(String uuid) {
        super(uuid);
    }

    public ProductoID() {
    }

    public static ProductoID of(String value){
        return new ProductoID(value);
    }
}
