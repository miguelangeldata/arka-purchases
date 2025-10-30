package com.store.purchases.domain.ports.out;

public interface ProductClientPort {
    void incrementStock(Long productId,Integer quantity);

}
