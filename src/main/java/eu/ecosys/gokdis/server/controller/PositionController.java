package eu.ecosys.gokdis.server.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.entity.Position;
import eu.ecosys.gokdis.server.repository.PositionRepository;

@RestController
@RequestMapping("api/v1")
public class PositionController {
    @Autowired
    private PositionRepository repository;

    @GetMapping(value = "/position")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Position> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/position/{id}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Position findById(@PathVariable UUID id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping(value = "/position")
    @PreAuthorize("hasRole('ADMIN')")
    public Position savePositionById(@RequestBody Position position) {
        return repository.save(new Position(
                position.id(), position.personEmail(),
                position.x(), position.y(),
                position.time()));
    }

    @DeleteMapping(value = "/position/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable UUID id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}