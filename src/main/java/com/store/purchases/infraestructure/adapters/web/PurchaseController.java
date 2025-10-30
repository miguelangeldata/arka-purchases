package com.store.purchases.infraestructure.adapters.web;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.purchases.domain.models.PurchaseId;
import com.store.purchases.domain.models.PurchaseItem;
import com.store.purchases.domain.ports.in.PurchaseUsesCases;
import com.store.purchases.infraestructure.adapters.mappers.PurchaseItemMapper;
import com.store.purchases.infraestructure.adapters.mappers.PurchaseMapper;
import com.store.purchases.infraestructure.adapters.web.dto.PurchaseItemDto;
import com.store.purchases.infraestructure.adapters.web.dto.PurchaseReponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseController  {
    private final PurchaseUsesCases usesCases;
    private final PurchaseMapper mapper;
    private final PurchaseItemMapper itemMapper;
    
    @PostMapping
    public ResponseEntity<PurchaseReponseDto> createPrchase(@RequestBody List<PurchaseItemDto> itemrequest){
       List<PurchaseItem> items= itemMapper.dtoDomainList(itemrequest);
       PurchaseReponseDto newPurchase= mapper.domainToDtoResponse(usesCases.createPurchase(items));
       return ResponseEntity.ok(newPurchase);

    }
    @GetMapping("/{purchaseId}")
    public ResponseEntity<PurchaseReponseDto> getById(@PathVariable("purchaseId") UUID purchaseId){
        var id= new PurchaseId(purchaseId);
        return usesCases.getById(id)
                        .map(mapper::domainToDtoResponse)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<PurchaseReponseDto>> getAll(){
        List<PurchaseReponseDto> purchases= usesCases.getAll()
                                            .stream()
                                            .map(mapper::domainToDtoResponse)
                                            .collect(Collectors.toList());
        return ResponseEntity.ok(purchases);
        
    }
    @DeleteMapping("/{purchaseId}")
    public ResponseEntity<Void> deletePurchase(@PathVariable UUID purchaseId){
        var id= new PurchaseId(purchaseId);
        usesCases.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

