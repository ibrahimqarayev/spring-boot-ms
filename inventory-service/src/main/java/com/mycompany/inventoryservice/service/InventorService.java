package com.mycompany.inventoryservice.service;

import com.mycompany.inventoryservice.repository.InventorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventorService {
    private final InventorRepository inventorRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return inventorRepository.findBySkuCode(skuCode).isPresent();
    }


}
