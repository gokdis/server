package eu.ecosys.gokdis.server.repository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.entity.Beacon;

public interface BeaconRepository extends CrudRepository<Beacon, UUID> {
    Optional<Beacon> findByMac(String mac);

    default Beacon updateByMac(String mac, Beacon updatedBeacon) {
        return findByMac(mac).map(existingBeacon -> {
            Beacon updatedRecord = new Beacon(
                    existingBeacon.mac(),
                    updatedBeacon.id(),
                    updatedBeacon.x(),
                    updatedBeacon.y()

            );
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Beacon not found with mac: " + mac));
    }
}