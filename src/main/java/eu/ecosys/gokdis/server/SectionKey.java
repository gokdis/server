package eu.ecosys.gokdis.server;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public record SectionKey(@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) int x1,
        @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) int y1,
        @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) int x2,
        @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) int y2) {
}