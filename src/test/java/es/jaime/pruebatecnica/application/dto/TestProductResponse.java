package es.jaime.pruebatecnica.application.dto;

import es.jaime.pruebatecnica.product.application.dto.ProductResponse;
import es.jaime.pruebatecnica.shared.AbstractServiceTest;
import es.jaime.pruebatecnica.shared.TestUtilsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DisplayName("Product Response test")
public class TestProductResponse extends AbstractServiceTest {
    @Autowired
    private TestUtilsService testUtilsService;

    @Test
    void whenProduct_ShouldReturnOrderedProductResponse() {
        // arrange
        var products = testUtilsService.mockProductList();
        var productResponse = new ProductResponse();
        var expectedProductResponse = ProductResponse.builder().id(List.of(2L, 3L, 1L)).build();
        // act
        productResponse = productResponse.fromProductListShortBySequence(products);
        // assert
        Assertions.assertEquals(expectedProductResponse, productResponse);
    }

    @Test
    void whenProduct_ShouldReturnProductResponse() {
        // arrange
        var products = testUtilsService.mockProductList();
        var productResponse = new ProductResponse();
        var expectedProductResponse = ProductResponse.builder().id(List.of(1L, 2L, 3L)).build();
        // act
        productResponse = productResponse.fromProductList(products);
        // assert
        Assertions.assertEquals(expectedProductResponse, productResponse);
    }


}
