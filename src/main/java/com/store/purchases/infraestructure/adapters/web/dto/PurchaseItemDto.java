package com.store.purchases.infraestructure.adapters.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemDto {

    private Long productId;
    private Integer quantity;

}
