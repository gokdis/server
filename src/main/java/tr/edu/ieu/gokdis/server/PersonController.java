package tr.edu.ieu.gokdis.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1")
public class PersonController {
    @Autowired
    private PersonRepository repository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping(value = "/person")
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/person/{email}")
    public Person findByEmail(@PathVariable String email) {
        return repository.findByEmail(email).orElseThrow();
    }

    // TODO: implement logic
    @PutMapping(value = "/person/{email}")
    public Person updateByEmail(@PathVariable String email, @RequestBody Person person) {
        return repository.updateByEmail(email,person);
    }

    @PostMapping(value = "/person")
    public Person savePersonByEmail(@RequestBody Person person) {
        return repository.save(new Person(person.email(), passwordEncoder.encode(person.password()), person.role(),
                person.role(), person.age()));
    }

    @DeleteMapping(value = "/person/{email}")
    public void deleteByEmail(@PathVariable String email) {
        repository.delete(repository.findByEmail(email).orElseThrow());
    }
}