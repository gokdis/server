package eu.ecosys.gokdis.server.service;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.PageResponse;
import eu.ecosys.gokdis.server.entity.Product;
import eu.ecosys.gokdis.server.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public PageResponse<Product> findAll(Pageable pageable, String pagingState) {
        ByteBuffer decodedPagingState = !pagingState.isBlank()
                ? ByteBuffer.wrap(Base64.getUrlDecoder().decode(pagingState))
                : null;
        CassandraPageRequest cassandraPageRequest = CassandraPageRequest.of(pageable, decodedPagingState);
        Slice<Product> slice = productRepository.findAll(cassandraPageRequest);
        List<Product> content = slice.getContent();
        ByteBuffer nextPagingState = slice.hasNext() ? ((CassandraPageRequest) slice.nextPageable()).getPagingState()
                : null;
        byte[] bytes = new byte[nextPagingState.remaining()];
        nextPagingState.get(bytes);
        return !content.isEmpty()
                ? new PageResponse<Product>(content,
                        nextPagingState == null ? "" : Base64.getUrlEncoder().encodeToString(bytes))
                : null;
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