package eu.ecosys.gokdis.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Value("${cassandra.contactpoints}")
    private String contactPoints;

    @Value("${cassandra.keyspace}")
    private String keyspaceName;

    @Value("${cassandra.schemaaction}")
    private SchemaAction schemaAction;

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return schemaAction;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return List.of(CreateKeyspaceSpecification.createKeyspace(keyspaceName).ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true).withSimpleReplication());
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return List.of(DropKeyspaceSpecification.dropKeyspace(keyspaceName));
    }
}