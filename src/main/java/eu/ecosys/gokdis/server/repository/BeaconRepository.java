package eu.ecosys.gokdis.server.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.entity.Beacon;

public interface BeaconRepository extends CrudRepository<Beacon, UUID> {
    Optional<Beacon> findByMac(String mac);
}