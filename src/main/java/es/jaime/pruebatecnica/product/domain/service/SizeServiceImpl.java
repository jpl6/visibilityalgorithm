package es.jaime.pruebatecnica.product.domain.service;

import es.jaime.pruebatecnica.product.domain.dto.Size;
import es.jaime.pruebatecnica.product.domain.repository.SizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {
    private final SizeRepository sizeRepository;

    public SizeServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Override
    public List<Size> findAllByProductId(long productId) {
        return sizeRepository.findAllByProductId(productId).stream()
                .map(size -> Size.builder()
                        .id(size.getId())
                        .productId(size.getProductId())
                        .backSoon(size.isBacksoon())
                        .special(size.isSpecial())
                        .build())
                .toList();
    }
}
