package eu.ecosys.gokdis.server.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public record Product(@PrimaryKey String id, UUID sectionId, String name, String description, int stock, double price) {
}