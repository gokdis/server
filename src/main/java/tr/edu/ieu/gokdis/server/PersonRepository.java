package tr.edu.ieu.gokdis.server;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
    Optional<Person> findByEmail(String email);
}