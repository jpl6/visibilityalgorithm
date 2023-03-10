package es.jaime.pruebatecnica.product.infrastructure.repository;

import es.jaime.pruebatecnica.product.domain.entity.Size;
import es.jaime.pruebatecnica.product.domain.repository.SizeRepository;
import es.jaime.pruebatecnica.product.infrastructure.repository.jpa.SizeJPA;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SizePostgreSqlAdapter implements SizeRepository {

    private final SizeJPA sizeJPA;

    public SizePostgreSqlAdapter(SizeJPA sizeJPA) {
        this.sizeJPA = sizeJPA;
    }

    @Override
    public List<Size> findAllByProductId(long productId) {
        return sizeJPA.findAllByProductId(productId);
    }

}
