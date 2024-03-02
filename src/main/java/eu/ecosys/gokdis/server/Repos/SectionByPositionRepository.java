package eu.ecosys.gokdis.server.Repos;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.SectionByPosition;

public interface SectionByPositionRepository extends CrudRepository<SectionByPosition, UUID> {
    @Query("SELECT * FROM SectionByPosition WHERE x1 <= ?0 AND x2 >= ?0 AND y1 <= ?1 AND y2 >= ?1")
    Optional<SectionByPosition> findByPosition(int x, int y);
}