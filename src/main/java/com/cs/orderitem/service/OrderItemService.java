package com.cs.orderitem.service;

import com.cs.orderitem.api.OrderItem;
import com.cs.orderitem.dao.IOrderItemRepository;
import com.cs.orderitem.exception.OrderItemNotFoundException;
import com.cs.orderitem.transform.ApiToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.cs.orderitem.transform.ApiToEntity.converToEntity;
import static com.cs.orderitem.transform.ApiToEntity.entityToAPI;

@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    private IOrderItemRepository dao;

    @Override
    public List<Long> createOrderItems(List<OrderItem> orderItems) {
        if (Objects.isNull(orderItems))
            throw new IllegalArgumentException("OrderItem can not be null");
        List<com.cs.orderitem.entity.OrderItem> entities = ApiToEntity.converToEntity(orderItems);
        dao.saveAll(entities);
        return entities.stream().
                map(com.cs.orderitem.entity.OrderItem::getId).collect(Collectors.toList());
    }

    @Override
    public List<com.cs.orderitem.api.OrderItem> getOrderItems(List<Long> orderIds) throws OrderItemNotFoundException {
        Iterable<com.cs.orderitem.entity.OrderItem>orderItems = dao.findAllById(orderIds);
        List<OrderItem>apiItems = new ArrayList<>(orderIds.size());
        orderItems.forEach((i)->
            apiItems.add(entityToAPI(i)));
        return  apiItems;

    }

}
