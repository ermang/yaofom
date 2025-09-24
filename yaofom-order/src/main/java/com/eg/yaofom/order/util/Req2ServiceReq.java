package com.eg.yaofom.order.util;


import com.eg.yaofom.order.req.AddToCartReq;
import com.eg.yaofom.order.service.SecurityService;
import com.eg.yaofom.order.servicereq.AddToCartServiceReq;
import org.springframework.stereotype.Component;

@Component
public class Req2ServiceReq {

    private final SecurityService securityService;

    public Req2ServiceReq(SecurityService securityService) {
        this.securityService = securityService;
    }

//    public CreateDinerServiceReq createDinerReq2CreateDinerServiceReq(CreateDinerReq req) {
//        CreateDinerServiceReq serviceReq = new CreateDinerServiceReq();
//        serviceReq.name = req.name;
//        serviceReq.descr = req.descr;
//        serviceReq.address = req.address;
//        serviceReq.userId = securityService.getUserId();
//
//        return serviceReq;
//    }
//
//    public CreateProductServiceReq createProductReq2CreateProductServiceReq(CreateProductReq req) {
//        CreateProductServiceReq serviceReq = new CreateProductServiceReq();
//        serviceReq.name = req.name;
//        serviceReq.description = req.description;
//        serviceReq.price = req.price;
//        serviceReq.userId = securityService.getUserId();
//        serviceReq.dinerId = req.dinerId;
//
//        return serviceReq;
//    }

    public AddToCartServiceReq addToCartReq2AddToCartServiceReq(AddToCartReq req) {
        AddToCartServiceReq serviceReq = new AddToCartServiceReq();
        serviceReq.productId = req.productId;
        serviceReq.quantity = req.quantity;
        serviceReq.userId = securityService.getUserId();

        return serviceReq;
    }
}

