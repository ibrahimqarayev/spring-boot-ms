package com.mycompany.inventoryservice.controller;

import com.mycompany.inventoryservice.service.InventorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventor")
public class InventorController {
    private final InventorService inventorService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode) {
        return inventorService.isInStock(skuCode);
    }

}
