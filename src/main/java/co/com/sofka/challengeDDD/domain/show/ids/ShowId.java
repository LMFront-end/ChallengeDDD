package co.com.sofka.challengeDDD.domain.show.ids;

import co.com.sofka.domain.generic.Identity;

public class ShowId extends Identity {

    // constructores

    public ShowId(String uuid) {
        super(uuid);
    }

    public ShowId() {
    }

    public static ShowId of(String value){
        return new ShowId(value);
    }
}
