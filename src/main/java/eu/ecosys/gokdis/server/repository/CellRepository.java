package eu.ecosys.gokdis.server.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.entity.Cell;

public interface CellRepository extends CrudRepository<Cell, UUID> {
    Optional<Cell> findByXAndY(int x, int y);

    Optional<Cell> findBySectionId(UUID sectionId);
}