package eu.ecosys.gokdis.server.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AuthenticationController {
    @GetMapping(value = "authentication")
    public String getUsername(Authentication authentication) {
        return authentication.getName();
    }
}