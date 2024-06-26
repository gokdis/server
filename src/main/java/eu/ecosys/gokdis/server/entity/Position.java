package eu.ecosys.gokdis.server.entity;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public record Position(@PrimaryKey UUID id, String personEmail, int x, int y, Timestamp time) {
}