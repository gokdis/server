package eu.ecosys.gokdis.server.Repos;

import org.springframework.data.repository.CrudRepository;
import eu.ecosys.gokdis.server.Product;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
    default Product updateById(UUID id, Product updatedProduct) {
        return findById(id).map(existingProduct -> {
            Product updatedRecord = new Product(
                    existingProduct.id(),
                    updatedProduct.sectionId() != null ? updatedProduct.sectionId() : existingProduct.sectionId(),
                    updatedProduct.name() != null ? updatedProduct.name() : existingProduct.name(),
                    updatedProduct.description() != null ? updatedProduct.description() : existingProduct.description(),
                    updatedProduct.stock(),
                    updatedProduct.price());
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }
}