package tr.edu.ieu.gokdis.server;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Table
public record Order(@PrimaryKey UUID id, UUID personId, UUID productId, String description, int quantity, Timestamp time) {
}