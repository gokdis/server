package tr.edu.ieu.gokdis.server;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(UUID id) {
        super("person " + id + " not found");
    }
}