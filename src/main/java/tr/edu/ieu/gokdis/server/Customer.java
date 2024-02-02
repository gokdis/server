package tr.edu.ieu.gokdis.server;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
public record Customer(
        @PrimaryKey UUID id,
        String name,
        String email,
        String password,
        int age,
        String phoneNumber,
        Date last_activity
) {
}
