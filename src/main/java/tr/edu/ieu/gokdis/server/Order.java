package tr.edu.ieu.gokdis.server;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
public record Order(@PrimaryKey UUID id, UUID customerId, UUID productId, String description, int quantity, Date time) {
}