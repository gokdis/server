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
import eu.ecosys.gokdis.server.service.PositionService;

@RestController
@RequestMapping("api/v1")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping(value = "/position")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Position> findAll() {
        return positionService.findAll();
    }

    @GetMapping(value = "/position/{id}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Position findById(@PathVariable UUID id) {
        return positionService.findById(id);
    }

    @PostMapping(value = "/position")
    @PreAuthorize("hasRole('ADMIN')")
    public Position savePosition(@RequestBody Position position) {
        return positionService.savePosition(position);
    }

    @DeleteMapping(value = "/position/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable UUID id) {
        positionService.deleteById(id);
    }
}