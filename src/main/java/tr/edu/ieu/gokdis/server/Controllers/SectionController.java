package tr.edu.ieu.gokdis.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.ieu.gokdis.server.Section;
import tr.edu.ieu.gokdis.server.Repos.SectionRepository;

@RestController
public class SectionController {
    @Autowired
    private SectionRepository repository;

    @GetMapping(value = "/section")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Section> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/section/{id}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Section findByMac(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/section/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Section updateByMac(@PathVariable String id, @RequestBody Section section) {
        return repository.updateById(id, section);
    }

    @PostMapping(value = "/section")
    @PreAuthorize("hasRole('ADMIN')")
    public Section saveSectionById(@RequestBody Section section) {
        return repository.save(new Section(section.id(), section.departmentId(), section.name(),
                section.x1(), section.x2(), section.y1(), section.y2()));
    }

    @DeleteMapping(value = "/section/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}