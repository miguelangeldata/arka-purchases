package com.store.purchases.domain.models;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Purchase {

    private  PurchaseId purchaseId;
    private List<PurchaseItem> items;
    private LocalDate introducedAt;

    public Purchase(PurchaseId purchaseId,List<PurchaseItem> items) {
        this.introducedAt = LocalDate.now();
        this.items = items;
        this.purchaseId = purchaseId;
    }

}
