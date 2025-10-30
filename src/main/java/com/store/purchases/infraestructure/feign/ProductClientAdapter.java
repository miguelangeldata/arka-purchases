package com.store.purchases.infraestructure.feign;

import com.store.purchases.domain.ports.out.ProductClientPort;
import com.store.purchases.infraestructure.adapters.web.dto.PurchaseItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductClientAdapter implements ProductClientPort {

    private final ProductsClient client;

    @Override
    public void incrementStock(Long productId, Integer quantity) {
        client.incrementStock(productId,quantity);
    }
}
