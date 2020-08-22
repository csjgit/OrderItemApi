package com.cs.orderitem.transform;

import com.cs.orderitem.entity.OrderItem;

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
}
