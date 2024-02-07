package tr.edu.ieu.gokdis.server.Repos;

import org.springframework.data.repository.CrudRepository;
import tr.edu.ieu.gokdis.server.Product;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {

    Optional<Product> findById(String id);


    default Product updateById(String id, Product updatedProduct) {
        return findById(id).map(existingProduct -> {
            Product updatedRecord = new Product(
                    existingProduct.id(),
                    updatedProduct.sectionId() != null ? updatedProduct.sectionId() : existingProduct.sectionId(),
                    updatedProduct.name() != null ? updatedProduct.name() : existingProduct.name(),
                    updatedProduct.description() != null ? updatedProduct.description() : existingProduct.description(),
                    updatedProduct.stock(),
                    updatedProduct.price()
            );
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }
}
