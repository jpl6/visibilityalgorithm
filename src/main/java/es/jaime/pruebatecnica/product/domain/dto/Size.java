package es.jaime.pruebatecnica.product.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class Size {

    private long id;
    private long productId;
    private boolean backSoon;
    private boolean special;

}
