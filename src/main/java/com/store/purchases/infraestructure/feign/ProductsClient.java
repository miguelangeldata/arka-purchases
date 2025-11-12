package com.store.purchases.infraestructure.feign;

import com.store.purchases.infraestructure.adapters.web.dto.PurchaseItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PRODUCTS-SERVICE",path = "/products")
public interface ProductsClient {
    @PostMapping("/increment/{productId}")
    public void incrementStock(
            @PathVariable("productId")Long productId,
            @RequestParam("quantity")Integer quantity);

}
