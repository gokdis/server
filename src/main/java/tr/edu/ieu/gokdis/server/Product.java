package tr.edu.ieu.gokdis.server;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public record Product(@PrimaryKey UUID id, UUID sectionId, String name, String description, int stock, double price) {
}