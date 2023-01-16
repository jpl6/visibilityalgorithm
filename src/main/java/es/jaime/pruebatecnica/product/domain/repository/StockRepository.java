package es.jaime.pruebatecnica.product.domain.repository;

import es.jaime.pruebatecnica.product.domain.dto.Stock;

import java.util.Optional;

public interface StockRepository {

    Optional<Stock> findBySizeId(long sizeId);
}
