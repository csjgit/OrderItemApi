package com.cs.orderitem.transform;

import com.cs.orderitem.entity.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class ApiToEntity {
    private ApiToEntity() {

    }

    public static OrderItem converToEntity(com.cs.orderitem.api.OrderItem orderItem) {

        com.cs.orderitem.entity.OrderItem orderItemEnity = new com.cs.orderitem.entity.OrderItem();
        orderItemEnity.setProductCode(orderItem.getProductCode());
        orderItemEnity.setQuantity(orderItem.getQuantity());
        orderItemEnity.setProductName(orderItem.getProductName());
        return orderItemEnity;
    }

    public static List<OrderItem> converToEntity(List<com.cs.orderitem.api.OrderItem> orderItems) {

        return orderItems.stream().map(i -> converToEntity(i))
                .collect(Collectors.toList());
    }

    public static com.cs.orderitem.api.OrderItem entityToAPI(OrderItem orderItem) {
        com.cs.orderitem.api.OrderItem apiOrderItem = new com.cs.orderitem.api.OrderItem();
        apiOrderItem.setProductName(orderItem.getProductName());
        apiOrderItem.setQuantity(orderItem.getQuantity());
        apiOrderItem.setProductCode(orderItem.getProductCode());
        return apiOrderItem;

    }
}
