package eu.ecosys.gokdis.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.entity.Beacon;
import eu.ecosys.gokdis.server.service.BeaconService;

@RestController
@RequestMapping("api/v1")
public class BeaconController {
    @Autowired
    private BeaconService beaconService;

    @GetMapping(value = "/beacon")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Beacon> findAll() {
        return beaconService.findAll();
    }

    @GetMapping(value = "/beacon/{mac}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Beacon findByMac(@PathVariable String mac) {
        return beaconService.findByMac(mac);
    }

    @PutMapping(value = "/beacon/{mac}")
    @PreAuthorize("hasRole('ADMIN')")
    public Beacon updateByMac(@PathVariable String mac, @RequestBody Beacon beacon) {
        return beaconService.updateByMac(mac, beacon);
    }

    @PostMapping(value = "/beacon")
    @PreAuthorize("hasRole('ADMIN')")
    public Beacon saveBeaconByMac(@RequestBody Beacon beacon) {
        return beaconService.save(beacon);
    }

    @DeleteMapping(value = "/beacon/{mac}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteByMac(@PathVariable String mac) {
        beaconService.deleteByMac(mac);
    }
}