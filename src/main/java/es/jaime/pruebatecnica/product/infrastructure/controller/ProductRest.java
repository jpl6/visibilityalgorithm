package es.jaime.pruebatecnica.product.infrastructure.controller;

import es.jaime.pruebatecnica.product.application.ShowAvailable;
import es.jaime.pruebatecnica.product.application.dto.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductRest {
    private final ShowAvailable showAvailable;

    public ProductRest(ShowAvailable showAvailable) {
        this.showAvailable = showAvailable;
    }

    @GetMapping("stock")
    public ResponseEntity<ProductResponse> filterAvailableProducts() {
        var availableProducts = showAvailable.showAvailableProducts();
        return !availableProducts.getId().isEmpty() ? new ResponseEntity<>(availableProducts, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
