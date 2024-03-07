package eu.ecosys.gokdis.server.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public record Person(@PrimaryKey String email, String password, String role, String name, String surname, int age,
        String gender) {
}