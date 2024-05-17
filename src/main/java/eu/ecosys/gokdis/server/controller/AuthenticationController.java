package eu.ecosys.gokdis.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.service.AuthenticationService;

@RestController
@RequestMapping("api/v1")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "authentication")
    public String getUsername(Authentication authentication) {
        return authenticationService.getUsername(authentication);
    }
}