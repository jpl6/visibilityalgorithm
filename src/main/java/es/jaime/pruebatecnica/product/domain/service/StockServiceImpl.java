package es.jaime.pruebatecnica.product.domain.service;

import es.jaime.pruebatecnica.product.domain.dto.Stock;
import es.jaime.pruebatecnica.product.domain.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Optional<Stock> findBySizeId(long sizeId) {
        return stockRepository.findBySizeId(sizeId).map(stock -> Stock.builder().sizeId(stock.getSizeId()).quantity(stock.getQuantity()).build());
    }
}
