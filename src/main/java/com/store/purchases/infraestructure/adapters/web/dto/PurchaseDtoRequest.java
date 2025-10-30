package com.store.purchases.infraestructure.adapters.web.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDtoRequest {

    private List<PurchaseItemDto> items;
    

}
