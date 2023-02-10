package com.mycompany.orderservice.converter;

import com.mycompany.orderservice.dto.OrderLineItemsDto;
import com.mycompany.orderservice.model.OrderLineItems;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public OrderLineItems mapToOrderLineItems(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        return orderLineItems;
    }

}
