package eu.ecosys.gokdis.server.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.ecosys.gokdis.server.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
    Optional<Person> findByEmail(String email);

}