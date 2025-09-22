package com.eg.yaecm.product.util;

import com.eg.yaecm.product.req.CreateProductReq;
import com.eg.yaecm.product.service.SecurityService;
import com.eg.yaecm.product.servicereq.CreateProductServiceReq;
import org.springframework.stereotype.Component;

@Component
public class Req2ServiceReq {

    private final SecurityService securityService;

    public Req2ServiceReq(SecurityService securityService) {
        this.securityService = securityService;
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
