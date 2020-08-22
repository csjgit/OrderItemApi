package com.cs.orderitem.controller;

import com.cs.orderitem.exception.OrderItemNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionCOntroller extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = {OrderItemNotFoundException.class})
    protected ResponseEntity<String> handle(
            OrderItemNotFoundException ex, WebRequest request) {
        String bodyOfResponse = "OrderItem could not be found";
        return new ResponseEntity<String>(bodyOfResponse, HttpStatus.OK);
    }
}
