package eu.ecosys.gokdis.server.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.ecosys.gokdis.server.entity.Section;
import eu.ecosys.gokdis.server.repository.SectionRepository;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public Iterable<Section> findAll() {
        return sectionRepository.findAll();
    }

    @Transactional
    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    @Transactional
    public void delete(UUID id) {
        sectionRepository.deleteById(id);
    }
}