package eu.ecosys.gokdis.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.entity.Person;
import eu.ecosys.gokdis.server.service.PersonService;

@RestController
@RequestMapping("api/v1")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping(value = "/person")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Person> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/person/{email}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Person findByEmail(@PathVariable String email) {
        return service.findByEmail(email).orElse(null);
    }

    @PostMapping(value = "/person")
    public Person save(@RequestBody Person person) {
        return service.save(person);
    }

    @DeleteMapping(value = "/person/{email}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable String email) {
        service.delete(email);
    }
}