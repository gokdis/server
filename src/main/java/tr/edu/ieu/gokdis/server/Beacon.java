package tr.edu.ieu.gokdis.server;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public record Beacon(@PrimaryKey String mac, int x, int y) {
}