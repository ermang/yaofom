package com.eg.yaofom.diner.util;


import com.eg.yaofom.diner.entity.Product;
import com.eg.yaofom.diner.serviceresp.ReadProductServiceResp;
import org.springframework.stereotype.Component;

@Component
public class Entity2ServiceResp {
//
//    public ReadProductServiceResp product2ReadProductServiceResp(Product p) {
//        ReadProductServiceResp serviceResp = new ReadProductServiceResp(p.getId(), p.getName(), p.getDescr(), p.getPrice());
//
//        return serviceResp;
//    }

public ReadProductServiceResp product2ReadProductServiceResp(Product p) {
    ReadProductServiceResp serviceResp = new ReadProductServiceResp(p.getId(), p.getName(), p.getDescr(), p.getPrice());

    return serviceResp;
}
}
