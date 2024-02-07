package tr.edu.ieu.gokdis.server.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.ieu.gokdis.server.Product;
import tr.edu.ieu.gokdis.server.Repos.ProductRepository;

//ok
@RestController
@RequestMapping(value = "api/v1")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping(value = "/product")
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/product/{id}")
    public Product findById(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/product/{id}")
    public Product updateById(@PathVariable String id, @RequestBody Product product) {
        return repository.updateById(id,product);
    }

    @PostMapping(value = "/product")
    public Product saveProductById(@RequestBody Product product) {
        return repository.save(new Product(
                product.id(),product.sectionId(),
                product.name(),product.description(),
                product.stock(),product.price()));
    }

    @DeleteMapping(value = "/product/{id}")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}
