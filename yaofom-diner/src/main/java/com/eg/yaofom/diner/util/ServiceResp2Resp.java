package com.eg.yaofom.diner.util;

import com.eg.yaofom.diner.resp.ReadProductResp;
import com.eg.yaofom.diner.resp.ValidateOwnerResp;
import com.eg.yaofom.diner.serviceresp.ReadProductServiceResp;
import com.eg.yaofom.diner.serviceresp.ValidateOwnerServiceResp;
import org.springframework.stereotype.Component;

@Component
public class ServiceResp2Resp {

    public ReadProductResp readProductServiceResp2ReadProductResp(ReadProductServiceResp serviceResp) {
        ReadProductResp resp = new ReadProductResp(serviceResp.id, serviceResp.description, serviceResp.description, serviceResp.price);

        return resp;
    }
}
