package eu.ecosys.gokdis.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import eu.ecosys.gokdis.server.Section;
import eu.ecosys.gokdis.server.Repos.SectionRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SectionController {
    @Autowired
    private SectionRepository repository;

    @GetMapping(value = "/section")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Section> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/section/{name}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Section findByMac(@PathVariable String name) {
        return repository.findByName(name).orElseThrow();
    }

    @GetMapping("/sections")
    public List<Section> getCollidingSections(
            @RequestParam("userX") int userX,
            @RequestParam("userY") int userY
    ) {
        return repository.findCollidingSections(userX, userX, userY, userY);
    }

    @PutMapping(value = "/section/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public Section updateByName(@PathVariable String name, @RequestBody Section section) {
        return repository.updateByName(name, section);
    }

    @PostMapping(value = "/section")
    @PreAuthorize("hasRole('ADMIN')")
    public Section saveSectionByName(@RequestBody Section section) {
        return repository.save(new Section(section.name(), section.x1(), section.y1(), section.x2(), section.y2()));
    }

    @DeleteMapping(value = "/section/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable String name) {
        repository.delete(repository.findByName(name).orElseThrow());
    }
}