package com.cs.orderitem.dao;

import com.cs.orderitem.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface IOrderItemRepository extends CrudRepository<OrderItem,Long> {

}
