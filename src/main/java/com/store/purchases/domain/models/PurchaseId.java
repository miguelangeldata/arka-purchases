package com.store.purchases.domain.models;

import java.util.Objects;
import java.util.UUID;

public record  PurchaseId(UUID value) {

    public PurchaseId {
        Objects.requireNonNull(value, "PurchaseId value cannot be null");
    }
    @Override
    public String toString() {
        return value.toString();
    }


}
