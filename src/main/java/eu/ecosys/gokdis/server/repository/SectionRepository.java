package eu.ecosys.gokdis.server.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.entity.Section;

public interface SectionRepository extends CrudRepository<Section, UUID> {
}