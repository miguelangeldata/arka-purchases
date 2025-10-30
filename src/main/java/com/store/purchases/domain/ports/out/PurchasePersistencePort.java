package com.store.purchases.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.store.purchases.domain.models.Purchase;
import com.store.purchases.domain.models.PurchaseId;

public interface PurchasePersistencePort {

    Purchase save(Purchase purchase);
    Optional<Purchase> findById(PurchaseId id);
    List<Purchase> findAll();
    void delete(PurchaseId id);
    
    
    

}
