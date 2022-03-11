package co.com.sofka.challengeDDD.domain.generics;

import co.com.sofka.challengeDDD.domain.generics.properties_values.EmailProperties;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<EmailProperties> {

    // declaración de variables
    private final String correo;

    // constructor email
    public Email(String correo) {
        this.correo = correo;
    }

    @Override
    public EmailProperties value() {
        return new EmailProperties() {

            @Override
            public String correo() {
                return correo;
            }
        };
    }

    // implementación de equals y el hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return correo.equals(email.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }
}
