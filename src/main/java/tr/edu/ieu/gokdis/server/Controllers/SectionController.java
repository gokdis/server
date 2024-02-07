package tr.edu.ieu.gokdis.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.ieu.gokdis.server.Repos.SectionRepository;
import tr.edu.ieu.gokdis.server.Section;

//ok
@RestController
@RequestMapping(value = "api/v1")
public class SectionController {

    @Autowired
    private SectionRepository repository;

    @GetMapping(value = "/section")
    public Iterable<Section> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/section/{id}")
    public Section findByMac(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/section/{id}")
    public Section updateByMac(@PathVariable String id, @RequestBody Section section) {
        return repository.updateById(id,section);
    }

    @PostMapping(value = "/section")
    public Section saveSectionById(@RequestBody Section section) {
        return repository.save(new Section(section.id(),section.departmentId(),section.name(),
                section.x1(),section.x2(),section.y1(), section.y2()));
    }

    @DeleteMapping(value = "/section/{id}")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}