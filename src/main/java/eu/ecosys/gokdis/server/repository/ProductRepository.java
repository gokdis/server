package eu.ecosys.gokdis.server.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import eu.ecosys.gokdis.server.entity.Product;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
    Slice<Product> findAllByPage(Pageable pageable);
}