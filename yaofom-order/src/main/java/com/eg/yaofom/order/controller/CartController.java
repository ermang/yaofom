package com.eg.yaofom.order.controller;


import com.eg.yaofom.order.req.AddToCartReq;
import com.eg.yaofom.order.req.ReadCartResp;
import com.eg.yaofom.order.service.CartServive;
import com.eg.yaofom.order.servicereq.AddToCartServiceReq;
import com.eg.yaofom.order.servicereq.ReadCartServiceResp;
import com.eg.yaofom.order.util.Req2ServiceReq;
import com.eg.yaofom.order.util.ServiceResp2Resp;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
public class CartController {

    private final Req2ServiceReq req2ServiceReq;
    private final ServiceResp2Resp serviceResp2Resp;
    private final CartServive cartServive;

    public CartController(Req2ServiceReq req2ServiceReq, ServiceResp2Resp serviceResp2Resp, CartServive cartServive) {
        this.req2ServiceReq = req2ServiceReq;
        this.serviceResp2Resp = serviceResp2Resp;
        this.cartServive = cartServive;
    }

    @PostMapping
    public void addToCart(@RequestBody AddToCartReq req) {
        AddToCartServiceReq serviceReq = req2ServiceReq.addToCartReq2AddToCartServiceReq(req);
        cartServive.addToCart(serviceReq);
    }

    @GetMapping
    public ReadCartResp readCart() {
        ReadCartServiceResp readCarServiceResp = cartServive.readCart();
        ReadCartResp readCartResp = serviceResp2Resp.readCartServiceResp2ReadCartResp(readCarServiceResp);

        return  readCartResp;
    }




//    @RolesAllowed("ADMIN")
//    @PostMapping
//    public void createDiner(@RequestBody CreateDinerReq req){
//        CreateDinerServiceReq serviceReq = req2ServiceReq.createDinerReq2CreateDinerServiceReq(req);
//        cartServive.createDiner(serviceReq);
//    }

//    @GetMapping("/{dinerId}/validate-owner")
//    public ValidateOwnerResp validateOwner(@PathVariable Long dinerId) {
//        ValidateOwnerServiceResp serviceResp = dinerService.validateOwner(dinerId);
//        ValidateOwnerResp resp = serviceResp2Resp.readProductServiceResp2ReadProductResp(serviceResp);
//
//        return resp;
//    }

//    @GetMapping("/{dinerId}/validate-owner")
//    public ValidateOwnerResp validateOwner(@PathVariable Long dinerId) {
//        ValidateOwnerServiceResp serviceResp = dinerService.validateOwner(dinerId);
//        ValidateOwnerResp resp = serviceResp2Resp.readProductServiceResp2ReadProductResp(serviceResp);
//
//        return resp;
//    }

//    @GetMapping("/{id}")
//    public ReadProductResp getDiner(@PathVariable("id") long id){
//
//        ReadProductServiceResp serviceResp = dinerService.getProduct(id);
//        ReadProductResp resp = serviceResp2Resp.readProductServiceResp2ReadProductResp(serviceResp);
//
//        return resp;
//    }
}
