package eu.ecosys.gokdis.server.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.entity.Matrix;

public interface MatrixRepository extends CrudRepository<Matrix, UUID> {
    Optional<Matrix> findByXAndY(int x, int y);

    Optional<Matrix> findBySectionId(UUID sectionId);
}