package eu.ecosys.gokdis.server.Repos;

import eu.ecosys.gokdis.server.Section;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public interface SectionRepository extends CrudRepository<Section, UUID> {

    Optional<Section> findByName(String name);
    @Query("SELECT * FROM section WHERE x1 <= ?0 AND x2 >= ?1 AND y1 <= ?2 AND y2 >= ?3 ALLOW FILTERING")
    List<Section> findCollidingSections(int x1, int x2, int y1, int y2);

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