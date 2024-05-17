package eu.ecosys.gokdis.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.entity.Cell;
import eu.ecosys.gokdis.server.service.CellService;

@RestController
@RequestMapping("api/v1")
public class CellController {
    @Autowired
    private CellService cellService;

    @GetMapping(value = "/cell/all")
    public Iterable<Cell> findAll() {
        return cellService.findAll();
    }

    @GetMapping(value = "/cell/{x}/{y}")
    public Cell findByXAndY(@PathVariable int x, @PathVariable int y) {
        return cellService.findByXAndY(x, y);
    }

    @PostMapping(value = "/cell")
    @PreAuthorize("hasRole('ADMIN')")
    public Cell saveMatrix(@RequestBody Cell cell) {
        return cellService.saveMatrix(cell);
    }

    @DeleteMapping(value = "/cell/{x}/{y}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable int x, @PathVariable int y) {
        cellService.deleteById(x, y);
    }
}