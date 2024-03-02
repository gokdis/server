package eu.ecosys.gokdis.server;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public record Section(@PrimaryKey UUID id, String name) {
}