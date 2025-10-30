package com.store.purchases.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.store.purchases.domain.models.Purchase;
import com.store.purchases.domain.models.PurchaseId;
import com.store.purchases.domain.models.PurchaseItem;
import com.store.purchases.domain.ports.in.PurchaseUsesCases;
import com.store.purchases.domain.ports.out.ProductClientPort;
import com.store.purchases.domain.ports.out.PurchasePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseService implements PurchaseUsesCases {

    private final PurchasePersistencePort persistence;
    private final ProductClientPort productClient;
    @Override
    public Purchase createPurchase(List<PurchaseItem> items) {
        var newId= new PurchaseId(UUID.randomUUID());
        Purchase newPurchase = new Purchase(newId, items);

        for(PurchaseItem item : items){
            productClient.incrementStock(item.getProductId(), item.getQuantity());
        }
        return persistence.save(newPurchase);
    }

    @Override
    public Optional<Purchase> getById(PurchaseId id) {
        return persistence.findById(id);
    }

    @Override
    public List<Purchase> getAll() {
        return persistence.findAll();
    }

    @Override
    public void deleteById( PurchaseId id) {
        persistence.delete(id);
    }

}
