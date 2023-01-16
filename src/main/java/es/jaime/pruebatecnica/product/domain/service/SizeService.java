package es.jaime.pruebatecnica.product.domain.service;

import es.jaime.pruebatecnica.product.domain.dto.Size;

import java.util.List;

public interface SizeService {

    List<Size> findAllByProductId(long productId);
}
