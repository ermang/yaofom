package com.eg.yaofom.order.client;


import com.eg.yaofom.order.clientresp.ReadProductResp;
import com.eg.yaofom.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "yaofom-diner", configuration = FeignConfig.class)
public interface DinerClient {

//    @GetMapping("/diner/{dinerId}/validate-owner")
//    ValidateOwnerClientResp validateOwner (@PathVariable Long dinerId);

    @GetMapping("/product/{id}")
    ReadProductResp getProduct (@PathVariable("id") Long id);
}
