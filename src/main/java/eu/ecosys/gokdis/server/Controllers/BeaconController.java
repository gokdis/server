package eu.ecosys.gokdis.server.Controllers;

import eu.ecosys.gokdis.server.Beacon;
import eu.ecosys.gokdis.server.Repos.BeaconRepository;
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

@RestController
@RequestMapping("api/v1")
public class BeaconController {
    @Autowired
    private BeaconRepository repository;

    @GetMapping(value = "/beacon")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Beacon> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/beacon/{mac}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Beacon findByMac(@PathVariable String mac) {
        return repository.findByMac(mac).orElseThrow();
    }

    @PutMapping(value = "/beacon/{mac}")
    @PreAuthorize("hasRole('ADMIN')")
    public Beacon updateByMac(@PathVariable String mac, @RequestBody Beacon beacon) {
        return repository.updateByMac(mac, beacon);
    }

    @PostMapping(value = "/beacon")
    @PreAuthorize("hasRole('ADMIN')")
    public Beacon saveBeaconByMac(@RequestBody Beacon beacon) {
        return repository.save(new Beacon(beacon.mac(), beacon.id(), beacon.x(), beacon.y()));
    }

    @DeleteMapping(value = "/beacon/{mac}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteByMac(@PathVariable String mac) {
        repository.delete(repository.findByMac(mac).orElseThrow());
    }
}