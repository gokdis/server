package eu.ecosys.gokdis.server.Repos;

import eu.ecosys.gokdis.server.Beacon;
import org.springframework.data.repository.CrudRepository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

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