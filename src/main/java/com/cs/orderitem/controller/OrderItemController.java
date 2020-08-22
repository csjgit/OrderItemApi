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
import java.util.Objects;


@RestController
public class OrderItemController {
    @Autowired
    private IOrderItemService orderItemService;

    @PostMapping("/createOrderItem")
    public ResponseEntity<String> createOrderItem(@RequestBody @Valid  OrderItem orderItem) {

        long orderId = orderItemService.createOrder(orderItem);
        if (Objects.isNull(orderId))
            return new ResponseEntity<>("Order could not be placed", HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>("" + orderId, HttpStatus.CREATED);

    }

    @GetMapping("/getOrderItem/{orderId}")
    public ResponseEntity<OrderItem> getOrderItem(@PathVariable("orderId") @NonNull Long orderId)
            throws OrderItemNotFoundException {

        OrderItem orderItem = orderItemService.getOrderItem(orderId);
        return new ResponseEntity<>(orderItem, HttpStatus.OK);

    }


}
