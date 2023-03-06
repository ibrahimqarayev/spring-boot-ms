package com.mycompany.orderservice.service;

import com.mycompany.orderservice.config.WebClientConfig;
import com.mycompany.orderservice.converter.OrderConverter;
import com.mycompany.orderservice.dto.reponse.InventoryResponse;
import com.mycompany.orderservice.dto.request.OrderRequest;
import com.mycompany.orderservice.model.Order;
import com.mycompany.orderservice.model.OrderLineItems;
import com.mycompany.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    private final WebClient.Builder webClientBuilder;

    @Transactional
    public String placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemsList(
                orderRequest.getOrderLineItemsDtoList()
                        .stream()
                        .map(orderConverter::mapToOrderLineItems).collect(Collectors.toList()));

        List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).collect(Collectors.toList());

        //Call inventory service and place order if product is in stock
        InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductInStock = Arrays.stream(inventoryResponseArray).allMatch(inventoryResponse -> inventoryResponse.isInStock());

        if (allProductInStock) {
            orderRepository.save(order);
            return "Order placed successfully ";
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }


    }

}
