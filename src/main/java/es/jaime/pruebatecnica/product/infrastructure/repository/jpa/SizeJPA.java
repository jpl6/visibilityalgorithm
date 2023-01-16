package es.jaime.pruebatecnica.product.infrastructure.repository.jpa;

import es.jaime.pruebatecnica.product.domain.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SizeJPA extends JpaRepository<Size, Long> {

    List<Size> findAllByProductId(long productId);
}
