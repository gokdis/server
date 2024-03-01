package eu.ecosys.gokdis.server;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public record Section(@PrimaryKey String name, int x1, int y1, int x2, int y2) {
}