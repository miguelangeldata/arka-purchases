package com.store.purchases.infraestructure.adapters.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.store.purchases.domain.models.Purchase;
import com.store.purchases.domain.models.PurchaseId;
import com.store.purchases.domain.ports.out.PurchasePersistencePort;
import com.store.purchases.infraestructure.adapters.mappers.PurchaseMapper;
import com.store.purchases.infraestructure.adapters.persistence.repository.PurchaseJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PurchasePersistenceAdapter implements PurchasePersistencePort {

    private final PurchaseMapper mapper;
    private final PurchaseJpaRepository repository;


    @Override
    public Purchase save(Purchase purchase) {
        return mapper.toDomain(repository.save(mapper.toEntity(purchase)));
    }

    @Override
    public Optional<Purchase> findById(PurchaseId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Purchase> findAll() {
        return repository.findAll().stream()
                         .map(mapper::toDomain)
                         .collect(Collectors.toList());
    }

    @Override
    public void delete(PurchaseId id) {
        repository.deleteById(id.value());
    }

}
