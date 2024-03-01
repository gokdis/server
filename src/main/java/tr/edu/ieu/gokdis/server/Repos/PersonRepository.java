package tr.edu.ieu.gokdis.server.Repos;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tr.edu.ieu.gokdis.server.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
    Optional<Person> findByEmail(String email);

    public default Person updateByEmail(String email, Person updatedPerson) {
        return findByEmail(email).map(existingPerson -> {
            Person updatedRecord = new Person(
                    existingPerson.email(),
                    updatedPerson.password() != null ? updatedPerson.password() : existingPerson.password(),
                    updatedPerson.role() != null ? updatedPerson.role() : existingPerson.role(),
                    updatedPerson.name() != null ? updatedPerson.name() : existingPerson.name(),
                    updatedPerson.surname() != null ? updatedPerson.surname() : existingPerson.surname(),
                    updatedPerson.age(),
                    updatedPerson.gender() != null ? updatedPerson.gender() : existingPerson.gender());
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Person not found with email: " + email));
    }

}