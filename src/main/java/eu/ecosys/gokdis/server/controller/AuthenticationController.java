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
import org.springframework.security.core.Authentication;

import eu.ecosys.gokdis.server.entity.Section;
import eu.ecosys.gokdis.server.repository.SectionRepository;

@RestController
@RequestMapping("api/v1")
public class AuthenticationController {
    @GetMapping(value = "authentication")
    public String getUsername(Authentication authentication) {
        return authentication.getName();
    }
}
