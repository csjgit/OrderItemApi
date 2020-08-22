package com.cs.orderitem.service;

import com.cs.orderitem.api.OrderItem;
import com.cs.orderitem.dao.IOrderItemRepository;
import com.cs.orderitem.exception.OrderItemNotFoundException;
import com.cs.orderitem.transform.ApiToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

import static com.cs.orderitem.transform.ApiToEntity.converToEntity;

@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    private IOrderItemRepository dao;

    @Override
    public long createOrder(OrderItem orderItem) {
        if (Objects.isNull(orderItem))
            throw new IllegalArgumentException("OrderItem can not be null");
        com.cs.orderitem.entity.OrderItem entity = ApiToEntity.converToEntity(orderItem);
        dao.save(entity);
        return entity.getId();
    }

    @Override
    public com.cs.orderitem.api.OrderItem getOrderItem(Long orderId) throws OrderItemNotFoundException {
        Optional<com.cs.orderitem.entity.OrderItem>orderItem = dao.findById(orderId);
        com.cs.orderitem.entity.OrderItem oi =  orderItem.orElseThrow(()->  new OrderItemNotFoundException());
        OrderItem apiOrderItem = new OrderItem();
        apiOrderItem.setProductName(oi.getProductName());
        apiOrderItem.setQuantity(oi.getQuantity());
        apiOrderItem.setProductCode(oi.getProductCode());
        return apiOrderItem;

    }

}
