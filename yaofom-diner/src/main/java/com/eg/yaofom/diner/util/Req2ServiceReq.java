package com.eg.yaofom.diner.util;

import com.eg.yaofom.diner.req.CreateDinerReq;
import com.eg.yaofom.diner.req.CreateProductReq;
import com.eg.yaofom.diner.service.SecurityService;
import com.eg.yaofom.diner.servicereq.CreateDinerServiceReq;
import com.eg.yaofom.diner.servicereq.CreateProductServiceReq;
import org.springframework.stereotype.Component;

@Component
public class Req2ServiceReq {

    private final SecurityService securityService;

    public Req2ServiceReq(SecurityService securityService) {
        this.securityService = securityService;
    }

    public CreateDinerServiceReq createDinerReq2CreateDinerServiceReq(CreateDinerReq req) {
        CreateDinerServiceReq serviceReq = new CreateDinerServiceReq();
        serviceReq.name = req.name;
        serviceReq.descr = req.descr;
        serviceReq.address = req.address;
        serviceReq.userId = securityService.getUserId();

        return serviceReq;
    }

    public CreateProductServiceReq createProductReq2CreateProductServiceReq(CreateProductReq req) {
        CreateProductServiceReq serviceReq = new CreateProductServiceReq();
        serviceReq.name = req.name;
        serviceReq.description = req.description;
        serviceReq.price = req.price;
        serviceReq.userId = securityService.getUserId();
        serviceReq.dinerId = req.dinerId;

        return serviceReq;
    }
}

