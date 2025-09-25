package com.eg.yaofom.order.controller;

import com.eg.yaofom.order.service.OrderService;
import com.eg.yaofom.order.service.SecurityService;
import com.eg.yaofom.order.util.Req2ServiceReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    private final Req2ServiceReq req2ServiceReq;
    private final OrderService orderService;
    private final SecurityService securityService;

    public OrderController(Req2ServiceReq req2ServiceReq, OrderService orderService, SecurityService securityService) {
        this.req2ServiceReq = req2ServiceReq;
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @PostMapping
    public void createOrder() {

        Long userId = securityService.getUserId();
        orderService.createOrder(userId);
    }
}
