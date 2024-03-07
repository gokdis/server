package eu.ecosys.gokdis.server.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public record Matrix(@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) int x, @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) int y, UUID sectionId) {
}