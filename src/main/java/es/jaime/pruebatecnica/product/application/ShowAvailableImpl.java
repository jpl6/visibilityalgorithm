package es.jaime.pruebatecnica.product.application;

import es.jaime.pruebatecnica.product.application.dto.ProductResponse;
import es.jaime.pruebatecnica.product.domain.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ShowAvailableImpl implements ShowAvailable {

    private final ProductService productService;

    public ShowAvailableImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductResponse showAvailableProducts() {
        var availableProducts = productService.filterAvailableProducts();
        return new ProductResponse().fromProductListShortBySequence(availableProducts);
    }
}
