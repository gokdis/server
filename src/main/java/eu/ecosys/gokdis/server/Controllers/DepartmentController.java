package eu.ecosys.gokdis.server.Controllers;

import eu.ecosys.gokdis.server.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.Repos.DepartmentRepository;

@RestController
@RequestMapping("api/v1")
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;

    @GetMapping(value = "/department")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Department> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/department/{id}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Department findById(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/department/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Department updateById(@PathVariable String id, @RequestBody Department department) {
        return repository.updateById(id, department);
    }

    @PostMapping(value = "/department")
    @PreAuthorize("hasRole('ADMIN')")
    public Department saveDepartmentById(@RequestBody Department department) {
        return repository.save(new Department(department.id(), department.name()));
    }

    @DeleteMapping(value = "/department/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}