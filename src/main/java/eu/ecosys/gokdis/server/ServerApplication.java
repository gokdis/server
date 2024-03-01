package eu.ecosys.gokdis.server;

import eu.ecosys.gokdis.server.Repos.PersonRepository;
import eu.ecosys.gokdis.server.Repos.SectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.UUID;

@SpringBootApplication
public class ServerApplication {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner savePeople(PersonRepository personRepository) {
        return args -> {
            personRepository.deleteAll();
            personRepository.save(new Person(
                    "helen@gokdis.ecosys.eu",
                    passwordEncoder.encode("helen"),
                    "ROLE_ADMIN",
                    "Helen",
                    "of Troy",
                    17,
                    "Female"));
            personRepository.save(new Person(
                    "kerberos@gokdis.ecosys.eu",
                    passwordEncoder.encode("kerberos"),
                    "ROLE_MOD",
                    "kerberos",
                    "of Tartarus",
                    18,
                    "Male"));
            personRepository.save(new Person(
                    "paris@gokdis.ecosys.eu",
                    passwordEncoder.encode("paris"),
                    "ROLE_USER",
                    "Paris",
                    "of Troy",
                    19,
                    "Male"));
        };

    }

    @Bean
    public CommandLineRunner saveSection(SectionRepository sectionRepository) {
        return args -> {

            UUID sectionId = UUID.fromString("3931227c-667a-4df7-a950-d49d62368c66");
            UUID departmentId = UUID.fromString("3931227c-667a-4df7-a950-d49d62368c66");

            sectionRepository.deleteAll();
            sectionRepository.save(new Section(
                    "Food Aisle",
                    0,
                    0,
                    4,
                    2
            ));
            sectionRepository.save(new Section(
                    "Diaper Aisle",
                    5,
                    0,
                    10,
                    2
            ));


        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:5173");
            }
        };
    }
}