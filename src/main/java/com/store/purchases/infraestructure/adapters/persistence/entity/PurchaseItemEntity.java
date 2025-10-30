package com.store.purchases.infraestructure.adapters.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemEntity {

    private Long productId;
    private Integer quantity;
    

}
