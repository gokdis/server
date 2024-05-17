package eu.ecosys.gokdis.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.Person;
import eu.ecosys.gokdis.server.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    public Optional<Person> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Person updateByEmail(String email, Person person) {
        return repository.updateByEmail(email, person);
    }

    public Person save(Person person) {
        return repository.save(new Person(
                person.email(),
                passwordEncoder.encode(person.password()),
                person.role(),
                person.name(),
                person.surname(),
                person.age(),
                person.gender()));
    }

    public void delete(String email) {
        repository.delete(repository.findByEmail(email).get());
    }
}