package com.store.purchases.infraestructure.adapters.web.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseReponseDto {

    private UUID id;
    private List<PurchaseItemDto> items;
    private LocalDate createAt;

}
