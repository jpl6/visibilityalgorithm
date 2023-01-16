package es.jaime.pruebatecnica.product.domain.service;

import es.jaime.pruebatecnica.product.domain.dto.Product;
import es.jaime.pruebatecnica.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }
}
