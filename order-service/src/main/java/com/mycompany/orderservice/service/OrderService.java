package com.mycompany.orderservice.service;

import com.mycompany.orderservice.converter.OrderConverter;
import com.mycompany.orderservice.dto.request.OrderRequest;
import com.mycompany.orderservice.model.Order;
import com.mycompany.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    @Transactional
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemsLong(
                orderRequest.getOrderLineItemsDtoList()
                        .stream()
                        .map(orderConverter::mapToOrderLineItems).collect(Collectors.toList()));

    }

}
