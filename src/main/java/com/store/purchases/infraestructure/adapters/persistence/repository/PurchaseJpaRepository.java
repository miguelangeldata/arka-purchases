package com.store.purchases.infraestructure.adapters.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.purchases.infraestructure.adapters.persistence.entity.PurchaseEntity;

public interface PurchaseJpaRepository extends JpaRepository<PurchaseEntity,UUID > {

}
