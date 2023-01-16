package es.jaime.pruebatecnica.product.domain.service;

import es.jaime.pruebatecnica.product.domain.dto.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();
    List<Product> filterAvailableProducts();
}
