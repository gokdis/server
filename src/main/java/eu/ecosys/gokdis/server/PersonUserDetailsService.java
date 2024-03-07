package eu.ecosys.gokdis.server;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.Person;
import eu.ecosys.gokdis.server.repository.PersonRepository;

@Service
public class PersonUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Person person = repository.findByEmail(email).orElseThrow();
        return new User(email, person.password(), Set.of(new SimpleGrantedAuthority(person.role())));
    }
}