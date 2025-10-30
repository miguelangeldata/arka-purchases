package com.store.purchases.infraestructure.adapters.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.store.purchases.domain.models.PurchaseItem;
import com.store.purchases.infraestructure.adapters.persistence.entity.PurchaseItemEntity;
import com.store.purchases.infraestructure.adapters.web.dto.PurchaseItemDto;

@Component
public class PurchaseItemMapper {

    public PurchaseItem toDomainItem(PurchaseItemEntity itemEntity){
        return  new PurchaseItem(
            itemEntity.getProductId(), 
            itemEntity.getQuantity());
    }
    public PurchaseItemEntity toEntityItem(PurchaseItem purchaseItem){
        return new PurchaseItemEntity(
            purchaseItem.getProductId(), 
            purchaseItem.getQuantity());
    }
    public List<PurchaseItemEntity> toEntityItems(List<PurchaseItem> items){
        return items.stream().map(this::toEntityItem).collect(Collectors.toList());
        
    }
    public List<PurchaseItem> toDomainItems(List<PurchaseItemEntity> itemEntitys){
        return itemEntitys.stream().map(this::toDomainItem).collect(Collectors.toList());
    }
    // Domain - Web

    public PurchaseItem dtoToDomain(PurchaseItemDto itemDto){
        return new PurchaseItem(
            itemDto.getProductId(), 
            itemDto.getQuantity());
    }
    public PurchaseItemDto domainToDto(PurchaseItem item){
        return new PurchaseItemDto(
            item.getProductId(), item.getQuantity());
    }
    public List<PurchaseItem> dtoDomainList(List<PurchaseItemDto> items){
        return items.stream().map(this::dtoToDomain).collect(Collectors.toList());
    }
    public List<PurchaseItemDto> domainToDtoList(List<PurchaseItem> itemDtos){
        return itemDtos.stream().map(this::domainToDto).collect(Collectors.toList());
    }

}
