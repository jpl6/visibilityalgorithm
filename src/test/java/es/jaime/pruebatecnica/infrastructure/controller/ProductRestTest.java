package es.jaime.pruebatecnica.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.jaime.pruebatecnica.product.application.ShowAvailable;
import es.jaime.pruebatecnica.product.application.dto.ProductResponse;
import es.jaime.pruebatecnica.shared.AbstractServiceTest;
import es.jaime.pruebatecnica.shared.TestUtilsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("Product Controller test")
public class ProductRestTest extends AbstractServiceTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TestUtilsService testUtilsService;
    @MockBean
    private ShowAvailable showAvailable;

    @Test
    void whenApiCallAndProductResponseExist_ShouldReturnStatusOkAndList() throws Exception {
        // arrange
        ProductResponse productResponse = testUtilsService.mockProductResponse();
        Mockito.when(showAvailable.showAvailableProducts()).thenReturn(productResponse);
        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/product/stock"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        // asserts
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(productResponse));
    }

    @Test
    void whenApiCallAndProductResponseIsEMpty_ShouldReturnStatusNotFoundAndEmptyResponse() throws Exception {
        // arrange
        ProductResponse productResponse = testUtilsService.mockProductResponseEmpty();
        Mockito.when(showAvailable.showAvailableProducts()).thenReturn(productResponse);
        var expetctedResult = "";
        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/product/stock"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
        // asserts
        Assertions.assertEquals(result.getResponse().getContentAsString(), expetctedResult);
    }
}
