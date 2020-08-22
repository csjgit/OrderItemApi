package com.cs.orderitem.service;

import com.cs.orderitem.api.OrderItem;
import com.cs.orderitem.exception.OrderItemNotFoundException;

import java.util.Optional;

public interface IOrderItemService
{
   long createOrder(OrderItem orderItem);
   OrderItem getOrderItem(Long orderId) throws OrderItemNotFoundException;

}
