package tr.edu.ieu.gokdis.server;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public record Section(
        @PrimaryKey UUID id,
        UUID departmentId,
        String name,
        int x1,
        int y1,
        int x2,
        int y2)
{
}
