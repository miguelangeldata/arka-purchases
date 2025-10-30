package com.store.purchases.infraestructure.adapters.mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.store.purchases.domain.models.Purchase;
import com.store.purchases.domain.models.PurchaseId;
import com.store.purchases.infraestructure.adapters.persistence.entity.PurchaseEntity;
import com.store.purchases.infraestructure.adapters.web.dto.PurchaseDtoRequest;
import com.store.purchases.infraestructure.adapters.web.dto.PurchaseReponseDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PurchaseMapper {

    private final PurchaseItemMapper itemMapper;

    public Purchase toDomain(PurchaseEntity entity){
        var  purchaseId = new PurchaseId(entity.getPurchaseId());
        var items = entity.getItems().stream()
                          .map(itemMapper::toDomainItem)
                          .collect(Collectors.toList());
        return new Purchase(purchaseId, items);
    }
    public PurchaseEntity toEntity(Purchase purchase){
        var itemsEntity = purchase.getItems().stream()
                                  .map(itemMapper::toEntityItem)
                                  .collect(Collectors.toList());
        return new PurchaseEntity(purchase.getPurchaseId().value(), itemsEntity,purchase.getIntroducedAt());
    }
    // Domain to Web
    public Purchase dtoToDomain(PurchaseDtoRequest dtoRequest){
        var items= dtoRequest.getItems().stream()
                              .map(itemMapper::dtoToDomain)
                              .collect(Collectors.toList());
        return new Purchase(null, items);
    }
    public PurchaseReponseDto domainToDtoResponse(Purchase purchase){
        var itemsRequest= purchase.getItems().stream()
                                         .map(itemMapper::domainToDto)
                                         .collect(Collectors.toList());
        return new PurchaseReponseDto(
            purchase.getPurchaseId().value(), 
            itemsRequest, 
            purchase.getIntroducedAt());
    }

}
