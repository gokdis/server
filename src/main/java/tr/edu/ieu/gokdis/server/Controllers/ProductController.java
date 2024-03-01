package tr.edu.ieu.gokdis.server.Controllers;

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

import tr.edu.ieu.gokdis.server.Product;
import tr.edu.ieu.gokdis.server.Repos.ProductRepository;

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
    public Product findById(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/product/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateById(@PathVariable String id, @RequestBody Product product) {
        return repository.updateById(id, product);
    }

    @PostMapping(value = "/product")
    @PreAuthorize("hasRole('ADMIN')")
    public Product saveProductById(@RequestBody Product product) {
        return repository.save(new Product(
                product.id(), product.sectionId(),
                product.name(), product.description(),
                product.stock(), product.price()));
    }

    @DeleteMapping(value = "/product/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}