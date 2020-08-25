package com.cs.orderitem.service;

import com.cs.orderitem.api.OrderItem;
import com.cs.orderitem.exception.OrderItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IOrderItemService
{
   List<Long> createOrderItems(List<OrderItem> orderItem);
   List<OrderItem> getOrderItems(List<Long> orderIds) throws OrderItemNotFoundException;

}
