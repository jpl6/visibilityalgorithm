package es.jaime.pruebatecnica.product.domain.service;

import es.jaime.pruebatecnica.product.domain.dto.Stock;

import java.util.Optional;

public interface StockService {
    Optional<Stock> findBySizeId(long sizeId);
}
