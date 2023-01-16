package es.jaime.pruebatecnica.product.application.dto;

import es.jaime.pruebatecnica.product.domain.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private List<Long> id;

    public ProductResponse fromProductListShortBySequence(List<Product> products) {
        List<Long> result = new ArrayList<>();
        products.stream().sorted(Comparator.comparingLong(Product::getSequence)).forEach(product -> result.add(product.getId()));
        return ProductResponse.builder().id(result).build();
    }
    public ProductResponse fromProductList(List<Product> products) {
        List<Long> result = new ArrayList<>();
        products.forEach(product -> result.add(product.getId()));
        return ProductResponse.builder().id(result).build();
    }
}
