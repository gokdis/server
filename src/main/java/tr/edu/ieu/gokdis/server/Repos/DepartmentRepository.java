package tr.edu.ieu.gokdis.server.Repos;

import org.springframework.data.repository.CrudRepository;
import tr.edu.ieu.gokdis.server.Department;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public interface DepartmentRepository extends CrudRepository<Department, UUID> {

    Optional<Department> findById(String id);


    default Department updateById(String id, Department updatedDepartment) {
        return findById(id).map(existingDepartment -> {
            Department updatedRecord = new Department(
                    existingDepartment.id(),
                    updatedDepartment.name() != null ? updatedDepartment.name() : existingDepartment.name()
            );
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Department not found with id: " + id));
    }
}
