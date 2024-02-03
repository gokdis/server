package tr.edu.ieu.gokdis.server;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/person/{id}")
    public Person findById(@PathVariable UUID id) {
        return repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PutMapping(value = "/person/{id}")
    public Person updateById(@PathVariable UUID id, @RequestBody Person person) {
        return repository.save(
                new Person(person.id(), person.email(), person.password(), person.role(), person.name(), person.age()));
    }

    @PostMapping(value = "/person")
    public Person findPersonById(@RequestBody Person person) {
        return repository.save(person);
    }

    @DeleteMapping(value = "/person/{id}")
    public void deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}