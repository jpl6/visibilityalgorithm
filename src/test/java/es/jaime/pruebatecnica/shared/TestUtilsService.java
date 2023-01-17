package es.jaime.pruebatecnica.shared;

import es.jaime.pruebatecnica.product.application.dto.ProductResponse;
import es.jaime.pruebatecnica.product.domain.dto.Product;
import es.jaime.pruebatecnica.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TestUtilsService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse mockProductResponse() {
        return new ProductResponse().fromProductListShortBySequence(mockProductList());
    }

    public ProductResponse mockProductResponseEmpty() {
        return new ProductResponse().fromProductListShortBySequence(Collections.emptyList());
    }

    public Product mockProduct(long id, long sequence) {
        return Product.builder()
                .id(id)
                .sequence(sequence)
                .build();
    }

    public es.jaime.pruebatecnica.product.domain.entity.Product mockProductEntity(long id, long sequence) {
        return es.jaime.pruebatecnica.product.domain.entity.Product.builder()
                .id(id)
                .sequence(sequence)
                .build();
    }

    public List<Product> mockProductList() {
        return List.of(mockProduct(1L, 3L), mockProduct(2L, 1L), mockProduct(3L, 2L));
    }

    public List<es.jaime.pruebatecnica.product.domain.entity.Product> mockProductEntityList() {
        return List.of(mockProductEntity(1L, 3L), mockProductEntity(2L, 1L), mockProductEntity(3L, 2L));
    }

    public void saveProductList(List<es.jaime.pruebatecnica.product.domain.entity.Product> products) {
        products.forEach(product -> productRepository.save(product));
    }

    public List<Product> toDto(List<es.jaime.pruebatecnica.product.domain.entity.Product> products) {
        return products.stream()
                .map(product ->
                        Product.builder()
                                .id(product.getId())
                                .sequence(product.getSequence())
                                .build())
                .toList();
    }
}
