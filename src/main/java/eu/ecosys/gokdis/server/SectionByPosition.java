package eu.ecosys.gokdis.server;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public record SectionByPosition(@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED) int x1,
        @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED) int y1,
        @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.PARTITIONED) int x2,
        @PrimaryKeyColumn(ordinal = 3, type = PrimaryKeyType.PARTITIONED) int y2,
        String name) {
}