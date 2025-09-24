package com.eg.yaofom.order.util;

import com.eg.yaofom.order.req.ReadCartResp;
import com.eg.yaofom.order.servicereq.ReadCartServiceResp;
import org.springframework.stereotype.Component;

@Component
public class ServiceResp2Resp {
    public ReadCartResp readCartServiceResp2ReadCartResp(ReadCartServiceResp readCarServiceResp) {
        ReadCartResp readCartResp = new ReadCartResp(readCarServiceResp.cartItems);

        return readCartResp;
    }

//    public ReadProductResp readProductServiceResp2ReadProductResp(ReadProductServiceResp serviceResp) {
//        ReadProductResp resp = new ReadProductResp(serviceResp.id, serviceResp.description, serviceResp.description, serviceResp.price);
//
//        return resp;
//    }
}
