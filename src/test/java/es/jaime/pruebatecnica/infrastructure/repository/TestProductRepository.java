package es.jaime.pruebatecnica.infrastructure.repository;

import es.jaime.pruebatecnica.product.domain.repository.ProductRepository;
import es.jaime.pruebatecnica.shared.AbstractServiceTest;
import es.jaime.pruebatecnica.shared.TestUtilsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("Product Repository Test")
public class TestProductRepository extends AbstractServiceTest {
    @Autowired
    private TestUtilsService testUtilsService;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void whenFindAllProducts_shoudlReturnProductsList() {
        // arrange
        var expectedProductList = testUtilsService.mockProductEntityList();
        testUtilsService.saveProductList(expectedProductList);
        // act
        var products = productRepository.findAllProducts();
        // assert
        Assertions.assertEquals(expectedProductList, products);
    }
}
