package com.mycompany.inventoryservice.service;

import com.mycompany.inventoryservice.repository.InventorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventorService {
    private final InventorRepository inventorRepository;
}
