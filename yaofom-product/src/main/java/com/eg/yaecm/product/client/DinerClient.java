package com.eg.yaecm.product.client;

import com.eg.yaecm.product.clientresp.ValidateOwnerClientResp;
import com.eg.yaecm.product.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "yaofom-diner", configuration = FeignConfig.class)
public interface DinerClient {

    @GetMapping("/diner/{dinerId}/validate-owner")
    ValidateOwnerClientResp validateOwner (@PathVariable Long dinerId);
}
