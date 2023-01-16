package es.jaime.pruebatecnica.product.domain.repository;

import es.jaime.pruebatecnica.product.domain.dto.Size;

import java.util.List;

public interface SizeRepository {

    List<Size> findAllByProductId(long productId);
}
