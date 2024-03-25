package eu.ecosys.gokdis.server.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.entity.Position;

public interface PositionRepository extends CrudRepository<Position, UUID> {
}