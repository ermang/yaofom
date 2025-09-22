package com.eg.yaofom.diner.util;

import com.eg.yaofom.diner.resp.ValidateOwnerResp;
import com.eg.yaofom.diner.serviceresp.ValidateOwnerServiceResp;
import org.springframework.stereotype.Component;

@Component
public class ServiceResp2Resp {

    public ValidateOwnerResp readProductServiceResp2ReadProductResp(ValidateOwnerServiceResp serviceResp) {
        ValidateOwnerResp resp = new ValidateOwnerResp(serviceResp.valid);

        return resp;
    }
}
