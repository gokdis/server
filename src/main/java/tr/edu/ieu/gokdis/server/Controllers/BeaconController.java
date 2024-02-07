package tr.edu.ieu.gokdis.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.ieu.gokdis.server.Beacon;
import tr.edu.ieu.gokdis.server.Repos.BeaconRepository;
//ok
@RestController
@RequestMapping(value = "api/v1")
public class BeaconController {

    @Autowired
    private BeaconRepository repository;

    @GetMapping(value = "/beacon")
    public Iterable<Beacon> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/beacon/{mac}")
    public Beacon findByMac(@PathVariable String mac) {
        return repository.findByMac(mac).orElseThrow();
    }

    @PutMapping(value = "/beacon/{mac}")
    public Beacon updateByMac(@PathVariable String mac, @RequestBody Beacon beacon) {
        return repository.updateByMac(mac,beacon);
    }

    @PostMapping(value = "/beacon")
    public Beacon saveBeaconByMac(@RequestBody Beacon beacon) {
        return repository.save(new Beacon(beacon.mac(),beacon.x(), beacon.y()));
    }

    @DeleteMapping(value = "/beacon/{mac}")
    public void deleteByMac(@PathVariable String mac) {
        repository.delete(repository.findByMac(mac).orElseThrow());
    }
}