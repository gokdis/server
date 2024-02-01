package tr.edu.ieu.gokdis.server;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public record Person(@PrimaryKey UUID id, String name, String email, String password, int age) {
}