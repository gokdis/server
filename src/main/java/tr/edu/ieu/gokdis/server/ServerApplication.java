package tr.edu.ieu.gokdis.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ServerApplication {
    private static final Log LOG = LogFactory.getLog(ServerApplication.class);

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner savePeople(PersonRepository personRepository) {
        return args -> {
            personRepository.deleteAll();
        
            personRepository.save(new Person(
                "helen@ieu.edu.tr", 
                passwordEncoder.encode("helen"), 
                "ROLE_ADMIN",
                "Helen", 
                17, 
                "Female", 
                "Doe" 
            ));
            personRepository.save(new Person(
                "paris@ieu.edu.tr", 
                passwordEncoder.encode("paris"), 
                "ROLE_USER",
                "Paris", 
                18, 
                "Male", 
                "Smith" 
            ));
        
            personRepository.findAll()
                .forEach(p -> LOG.info(p.toString())); 
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