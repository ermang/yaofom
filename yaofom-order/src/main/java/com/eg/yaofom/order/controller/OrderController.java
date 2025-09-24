package com.eg.yaofom.order.controller;

import com.eg.yaofom.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder() {
        //AddToCartServiceReq serviceReq = req2ServiceReq.addToCartReq2AddToCartServiceReq(req);
        orderService.createOrder();
    }
}
