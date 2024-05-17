package eu.ecosys.gokdis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.ecosys.gokdis.server.entity.Beacon;
import eu.ecosys.gokdis.server.repository.BeaconRepository;

@Service
public class BeaconService {
    @Autowired
    private BeaconRepository beaconRepository;

    public Iterable<Beacon> findAll() {
        return beaconRepository.findAll();
    }

    @Transactional
    public Beacon findByMac(String mac) {
        return beaconRepository.findByMac(mac).orElseThrow();
    }

    @Transactional
    public Beacon updateByMac(String mac, Beacon beacon) {
        return beaconRepository.updateByMac(mac, beacon);
    }

    @Transactional
    public Beacon save(Beacon beacon) {
        return beaconRepository.save(beacon);
    }

    @Transactional
    public void deleteByMac(String mac) {
        beaconRepository.delete(beaconRepository.findByMac(mac).orElseThrow());
    }
}