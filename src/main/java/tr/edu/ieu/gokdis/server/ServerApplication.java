package tr.edu.ieu.gokdis.server;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

    private static final Log LOG = LogFactory.getLog(ServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner savePeople(PersonRepository personRepository) {
        return args -> {
            personRepository.deleteAll();

            personRepository.save(new Person(UUID.randomUUID(), "helen", "helen@ieu.edu.tr",
                    "80c95d0e9e710a56937209d81da3043b5dfed8174bb6acc01e334ecaa6408a97", 17));
            personRepository.save(new Person(UUID.randomUUID(), "paris", "paris@ieu.edu.tr",
                    "1670f2e42fefa5044d59a65349e47c566009488fc57d7b4376dd5787b59e3c57", 18));

            personRepository.findAll()
                    .forEach(p -> LOG.info(p));
        };
    }
}