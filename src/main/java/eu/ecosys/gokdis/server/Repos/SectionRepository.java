package eu.ecosys.gokdis.server.Repos;

import eu.ecosys.gokdis.server.Section;
import org.springframework.data.repository.CrudRepository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public interface SectionRepository extends CrudRepository<Section, UUID> {

    Optional<Section> findByName(String name);

    default Section updateByName(String name, Section updatedSection) {
        return findByName(name).map(existingSection -> {
            Section updatedRecord = new Section(
                    existingSection.name(),
                    updatedSection.x1(),
                    updatedSection.y1(),
                    updatedSection.x2(),
                    updatedSection.y2());
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Section not found with name: " + name));
    }
}