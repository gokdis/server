package eu.ecosys.gokdis.server.controller;

import java.util.UUID;

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

import eu.ecosys.gokdis.server.entity.Product;
import eu.ecosys.gokdis.server.repository.ProductRepository;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping(value = "/product")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/product/{id}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Product findById(@PathVariable UUID id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/product/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateById(@PathVariable UUID id, @RequestBody Product product) {
        return repository.updateById(id, product);
    }

    @PostMapping(value = "/product")
    @PreAuthorize("hasRole('ADMIN')")
    public Product save(@RequestBody Product product) {
        return repository.save(new Product(
                product.id(), product.sectionId(),
                product.name(), product.description(),
                product.stock(), product.price()));
    }

    @DeleteMapping(value = "/product/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}