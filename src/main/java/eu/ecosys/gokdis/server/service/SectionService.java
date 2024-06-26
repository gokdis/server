package eu.ecosys.gokdis.server.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.Section;
import eu.ecosys.gokdis.server.repository.SectionRepository;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public Iterable<Section> findAll() {
        return sectionRepository.findAll();
    }

    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    public void delete(UUID id) {
        sectionRepository.deleteById(id);
    }
}