package eu.ecosys.gokdis.server.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Table
public record CustomerOrder(@PrimaryKey UUID id, String personEmail, UUID productId, String description, int quantity, Timestamp time) {
}