package eu.ecosys.gokdis.server.Repos;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.Section;

public interface SectionRepository extends CrudRepository<Section, UUID> {
}