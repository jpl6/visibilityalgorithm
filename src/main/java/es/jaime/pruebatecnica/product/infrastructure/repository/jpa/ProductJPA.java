package es.jaime.pruebatecnica.product.infrastructure.repository.jpa;

import es.jaime.pruebatecnica.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPA extends JpaRepository<Product, Long> {

}
