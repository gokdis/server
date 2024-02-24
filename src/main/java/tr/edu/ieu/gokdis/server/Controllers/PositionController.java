package tr.edu.ieu.gokdis.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.ieu.gokdis.server.Position;
import tr.edu.ieu.gokdis.server.Repos.PositionRepository;

@RestController
@RequestMapping(value = "api/v1")
public class PositionController {
    @Autowired
    private PositionRepository repository;

    @GetMapping(value = "/position")
    public Iterable<Position> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/position/{id}")
    public Position findById(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/position/{id}")
    public Position updateById(@PathVariable String id, @RequestBody Position position) {
        return repository.updateById(id, position);
    }

    @PostMapping(value = "/position")
    public Position savePositionById(@RequestBody Position position) {
        return repository.save(new Position(
                position.id(), position.customerId(),
                position.x(), position.y(),
                position.time()));
    }

    @DeleteMapping(value = "/position/{id}")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}