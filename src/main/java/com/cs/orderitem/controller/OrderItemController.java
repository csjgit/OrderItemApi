package com.cs.orderitem.controller;

import com.cs.orderitem.api.OrderItem;
import com.cs.orderitem.exception.OrderItemNotFoundException;
import com.cs.orderitem.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@RestController
public class OrderItemController {
    @Autowired
    private IOrderItemService orderItemService;

    @PostMapping("/createOrderItems")
    public ResponseEntity<List<Long>> createOrderItems(@RequestBody @Valid List<OrderItem> orderItems) {

        List<Long> orderIds = orderItemService.createOrderItems(orderItems);
        if (Objects.isNull(orderIds))
            return new ResponseEntity("Order could not be placed", HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(orderIds, HttpStatus.CREATED);

    }

    @PostMapping("/getOrderItems")
    public ResponseEntity<List<OrderItem>> getOrderItems(@NonNull @RequestBody List<Long> orderIds)
            throws OrderItemNotFoundException {

        List<OrderItem> orderItems = orderItemService.getOrderItems(orderIds);
        return new ResponseEntity(orderItems, HttpStatus.OK);

    }


}
