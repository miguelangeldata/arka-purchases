package com.store.purchases.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseItem {

    private Long productId;
    private Integer quantity;

    public PurchaseItem(Long productId, Integer quantity) {
        
        if(quantity <0 ){

             throw new IllegalArgumentException("quantity mst be Valid");
        }
        this.productId = productId;
        this.quantity = quantity;
    }
    

}
