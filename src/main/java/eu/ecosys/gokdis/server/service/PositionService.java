package eu.ecosys.gokdis.server.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.Position;
import eu.ecosys.gokdis.server.repository.PositionRepository;

@Service
public class PositionService {
    @Autowired
    private PositionRepository repository;

    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Position> findAll() {
        return repository.findAll();
    }

    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Position findById(UUID id) {
        return repository.findById(id).orElseThrow();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Position savePosition(Position position) {
        return repository.save(new Position(
                position.id(), position.personEmail(),
                position.x(), position.y(),
                position.time()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(UUID id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}