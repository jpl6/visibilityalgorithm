package es.jaime.pruebatecnica.product.infrastructure.repository;

import es.jaime.pruebatecnica.product.domain.dto.Product;
import es.jaime.pruebatecnica.product.domain.repository.ProductRepository;
import es.jaime.pruebatecnica.product.infrastructure.repository.jpa.ProductJPA;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductPostgreSqlAdapter implements ProductRepository {
    private final ProductJPA productJPA;

    public ProductPostgreSqlAdapter(ProductJPA productJPA) {
        this.productJPA = productJPA;
    }

    @Override
    public List<Product> findAllProducts() {
        return productJPA.findAll().stream()
                .map(product -> Product.builder()
                                .id(product.getId())
                                .sequence(product.getSequence())
                                .build())
                .toList();
    }
}