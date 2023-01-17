package es.jaime.pruebatecnica.product.domain.repository;

import es.jaime.pruebatecnica.product.domain.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAllProducts();

    void save(Product product);
}
