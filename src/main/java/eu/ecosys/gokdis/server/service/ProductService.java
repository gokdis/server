package eu.ecosys.gokdis.server.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.Product;
import eu.ecosys.gokdis.server.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(UUID id) {
        return productRepository.findById(id).get();
    }

    public Product save(Product product) {
        return productRepository.save(new Product(
                product.id(), product.sectionId(),
                product.name(), product.description(),
                product.stock(), product.price()));
    }

    public void delete(UUID id) {
        productRepository.delete(productRepository.findById(id).get());
    }
}