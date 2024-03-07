package eu.ecosys.gokdis.server;

import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.datastax.oss.driver.api.core.CqlSession;

@SpringBootApplication
public class ServerApplication {
    @Autowired
    private CqlSession session;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Files.lines(Path.of("data.cql")).forEach(line -> {
                if (!line.isBlank()) {
                    session.execute(line);
                }
            });
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:5173").allowedMethods("GET", "POST", "PUT",
                        "DELETE");
            }
        };
    }
}
