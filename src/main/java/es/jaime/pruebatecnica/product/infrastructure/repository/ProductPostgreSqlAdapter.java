package es.jaime.pruebatecnica.product.infrastructure.repository;

import es.jaime.pruebatecnica.product.domain.entity.Product;
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
        return productJPA.findAll();
    }

    @Override
    public void save(Product product) {
        productJPA.save(product);
    }
}
