package es.jaime.pruebatecnica.product.infrastructure.repository;

import es.jaime.pruebatecnica.product.domain.dto.Stock;
import es.jaime.pruebatecnica.product.domain.repository.StockRepository;
import es.jaime.pruebatecnica.product.infrastructure.repository.jpa.StockJPA;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StockPostgreSqlAdapter implements StockRepository {

    private final StockJPA stockJPA;

    public StockPostgreSqlAdapter(StockJPA stockJPA) {
        this.stockJPA = stockJPA;
    }

    @Override
    public Optional<Stock> findBySizeId(long sizeId) {
        return stockJPA.findById(sizeId).map(stock -> Stock.builder().sizeId(stock.getSizeId()).quantity(stock.getQuantity()).build());
    }
}
