package es.jaime.pruebatecnica.product.infrastructure.repository.jpa;

import es.jaime.pruebatecnica.product.domain.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockJPA extends JpaRepository<Stock, Long> {


}
