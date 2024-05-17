package eu.ecosys.gokdis.server.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public String getUsername(Authentication authentication) {
        return authentication.getName();
    }
}