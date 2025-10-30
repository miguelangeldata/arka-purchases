package com.store.purchases.infraestructure.adapters.persistence.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "purchases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseEntity {

    @Id
    private UUID purchaseId;
    @ElementCollection
    @CollectionTable(name = "purchase_items", joinColumns = @JoinColumn(name = "purchase_id"))
    private List<PurchaseItemEntity> items;
    private LocalDate introducedAt;
    


}
