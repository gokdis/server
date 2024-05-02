package eu.ecosys.gokdis.server.controller;

import java.util.List;
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

import eu.ecosys.gokdis.server.entity.Product;
import eu.ecosys.gokdis.server.service.ProductService;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    /*
     * @GetMapping(value = "/product")
     * 
     * @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
     * public PageResponse<Product> findAllByPage(@RequestParam(defaultValue = "0")
     * int pageNumber,
     * 
     * @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue =
     * "") String pagingState) {
     * return productService.findAll(PageRequest.of(pageNumber, pageSize),
     * pagingState);
     * }
     */

    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/product/{id}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Product findById(@PathVariable UUID id) {
        return productService.findById(id);
    }

    @PostMapping(value = "/product")
    @PreAuthorize("hasRole('ADMIN')")
    public Product save(@RequestBody Product product) {
        return productService.save(new Product(
                product.id(), product.sectionId(),
                product.name(), product.description(),
                product.stock(), product.price()));
    }

    @DeleteMapping(value = "/product/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        productService.delete(id);
    }
}