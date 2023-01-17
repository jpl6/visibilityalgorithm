package es.jaime.pruebatecnica.domain.service;

import es.jaime.pruebatecnica.product.domain.repository.ProductRepository;
import es.jaime.pruebatecnica.product.domain.service.ProductService;
import es.jaime.pruebatecnica.shared.AbstractServiceTest;
import es.jaime.pruebatecnica.shared.TestUtilsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("Product Service Test")
public class TestProductService extends AbstractServiceTest {
    @Autowired
    private TestUtilsService testUtilsService;

    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;

    @Test
    void whenFindAll_ShouldReturnProductList() {
        // arrange
        var expectedProductEntityList = testUtilsService.mockProductEntityList();
        Mockito.when(productRepository.findAllProducts()).thenReturn(expectedProductEntityList);
        var expectedProductList = testUtilsService.toDto(expectedProductEntityList);
        // act
        var productList = productService.findAllProducts();
        // assert
        Assertions.assertEquals(expectedProductList, productList);

    }
}
