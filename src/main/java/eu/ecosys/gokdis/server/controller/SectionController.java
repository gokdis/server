package eu.ecosys.gokdis.server.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.entity.Section;
import eu.ecosys.gokdis.server.service.SectionService;

@RestController
@RequestMapping("api/v1")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @GetMapping(value = "/section")
    public Iterable<Section> findAll() {
        return sectionService.findAll();
    }

    @PostMapping(value = "/section")
    @PreAuthorize("hasRole('ADMIN')")
    public Section save(@RequestBody Section section) {
        return sectionService.save(section);
    }

    @DeleteMapping(value = "/section/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        sectionService.delete(id);
    }
}