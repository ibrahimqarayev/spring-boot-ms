package com.mycompany.orderservice.controlller;

import com.mycompany.orderservice.dto.request.OrderRequest;
import com.mycompany.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        return "Order Placed Successfully !";
    }

}
