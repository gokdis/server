package eu.ecosys.gokdis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.Beacon;
import eu.ecosys.gokdis.server.repository.BeaconRepository;

@Service
public class BeaconService {
    @Autowired
    private BeaconRepository beaconRepository;

    public Iterable<Beacon> findAll() {
        return beaconRepository.findAll();
    }

    public Beacon findByMac(String mac) {
        return beaconRepository.findByMac(mac).orElseThrow();
    }

    public Beacon save(Beacon beacon) {
        return beaconRepository.save(beacon);
    }

    public void delete(String mac) {
        beaconRepository.delete(beaconRepository.findByMac(mac).orElseThrow());
    }
}