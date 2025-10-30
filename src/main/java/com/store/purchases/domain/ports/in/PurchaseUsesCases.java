package com.store.purchases.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.store.purchases.domain.models.Purchase;
import com.store.purchases.domain.models.PurchaseId;
import com.store.purchases.domain.models.PurchaseItem;

public interface PurchaseUsesCases {

    Purchase createPurchase(List<PurchaseItem> items);
    Optional<Purchase> getById(PurchaseId id);
    List<Purchase> getAll();
    void deleteById(PurchaseId id);

}
