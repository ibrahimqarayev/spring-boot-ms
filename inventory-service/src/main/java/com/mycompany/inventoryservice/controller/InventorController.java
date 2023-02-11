package com.mycompany.inventoryservice.controller;

import com.mycompany.inventoryservice.service.InventorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/inventor")
public class InventorController {
    private final InventorService inventorService;
}
