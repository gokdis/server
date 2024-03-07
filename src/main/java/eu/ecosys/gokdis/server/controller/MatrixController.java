package eu.ecosys.gokdis.server.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.entity.Matrix;
import eu.ecosys.gokdis.server.repository.MatrixRepository;

@RestController
@RequestMapping("api/v1")
public class MatrixController {
    @Autowired
    private MatrixRepository matrixRepository;

    @GetMapping(value = "/matrix/all")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Matrix> findAll() {
        return matrixRepository.findAll();
    }

    @GetMapping(value = "/matrix/{x}/{y}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Matrix findByXAndY(@PathVariable int x, @PathVariable int y) {
        return matrixRepository.findByXAndY(x, y).orElseThrow();
    }

    @GetMapping(value = "/matrix/{sectionId}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Matrix findBySectionId(@PathVariable UUID sectionId) {
        return matrixRepository.findBySectionId(sectionId).orElseThrow();
    }

    @PostMapping(value = "/matrix")
    @PreAuthorize("hasRole('ADMIN')")
    public Matrix saveMatrix(@RequestBody Matrix matrix) {
        return matrixRepository
                .save(new Matrix(matrix.x(), matrix.y(), matrix.sectionId()));
    }

    @DeleteMapping(value = "/matrix/{x}/{y}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable int x, @PathVariable int y) {
        matrixRepository.delete(matrixRepository.findByXAndY(x, y).orElseThrow());
    }
}