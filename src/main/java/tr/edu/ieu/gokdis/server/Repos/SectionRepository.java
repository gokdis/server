package tr.edu.ieu.gokdis.server.Repos;

import org.springframework.data.repository.CrudRepository;
import tr.edu.ieu.gokdis.server.Section;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public interface SectionRepository extends CrudRepository<Section, UUID> {

    Optional<Section> findById(String id);


    default Section updateById(String id, Section updatedSection) {
        return findById(id).map(existingSection -> {
            Section updatedRecord = new Section(
                    existingSection.id(),
                    updatedSection.departmentId() != null ? updatedSection.departmentId() : existingSection.departmentId(),
                    updatedSection.name() != null ? updatedSection.name() : existingSection.name(),
                    updatedSection.x1(),
                    updatedSection.x2(),
                    updatedSection.y1(),
                    updatedSection.y2()
            );
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Section not found with id: " + id));
    }
}
