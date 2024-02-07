package tr.edu.ieu.gokdis.server.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.ieu.gokdis.server.Department;
import tr.edu.ieu.gokdis.server.Repos.DepartmentRepository;
//ok
@RestController
@RequestMapping(value = "api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repository;

    @GetMapping(value = "/department")
    public Iterable<Department> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/department/{id}")
    public Department findById(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/department/{id}")
    public Department updateById(@PathVariable String id, @RequestBody Department department) {
        return repository.updateById(id,department);
    }

    @PostMapping(value = "/department")
    public Department saveDepartmentById(@RequestBody Department department) {
        return repository.save(new Department(department.id(),department.name()));
    }

    @DeleteMapping(value = "/department/{id}")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}
