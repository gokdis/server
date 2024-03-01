package tr.edu.ieu.gokdis.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.ieu.gokdis.server.Position;
import tr.edu.ieu.gokdis.server.Repos.PositionRepository;

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
    public Position findById(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/position/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Position updateById(@PathVariable String id, @RequestBody Position position) {
        return repository.updateById(id, position);
    }

    @PostMapping(value = "/position")
    @PreAuthorize("hasRole('ADMIN')")
    public Position savePositionById(@RequestBody Position position) {
        return repository.save(new Position(
                position.id(), position.customerId(),
                position.x(), position.y(),
                position.time()));
    }

    @DeleteMapping(value = "/position/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}