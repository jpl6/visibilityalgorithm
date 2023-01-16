package es.jaime.pruebatecnica.product.domain.service;

import es.jaime.pruebatecnica.product.domain.dto.Product;
import es.jaime.pruebatecnica.product.domain.dto.Size;
import es.jaime.pruebatecnica.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final SizeService sizeService;
    private final StockService stockService;

    public ProductServiceImpl(ProductRepository productRepository, SizeService sizeService, StockService stockService) {
        this.productRepository = productRepository;
        this.sizeService = sizeService;
        this.stockService = stockService;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public List<Product> filterAvailableProducts() {
        var allProducts = findAllProducts();
        return allProducts.stream().filter(this::isAvailable).toList();
    }

    private boolean isAvailable(Product product) {
        var sizes = sizeService.findAllByProductId(product.getId());
        if (sizes.stream().anyMatch(Size::isSpecial)) {
            return hasStockSpecial(sizes);
        }
        return hasStock(sizes);
    }

    private boolean hasStockSpecial(List<Size> sizeList) {
        var specialList = sizeList.stream().filter(Size::isSpecial).toList();
        var regularList = sizeList.stream().filter(size -> !size.isSpecial()).toList();
        return hasStock(specialList) && hasStock(regularList);
    }

    private boolean hasStock(List<Size> sizeList) {
        return sizeList.stream().anyMatch(Size::isBackSoon) ||
                sizeList.stream().map(size -> stockService.findBySizeId(size.getId()))
                        .anyMatch(stock -> stock.isPresent() && stock.get().getQuantity() > 0);
    }
}
