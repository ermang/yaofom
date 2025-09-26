package com.eg.yaofom.diner.controller;


import com.eg.yaofom.diner.req.CreateDinerReq;
import com.eg.yaofom.diner.req.UpdateWorkingHoursReq;
import com.eg.yaofom.diner.service.DinerService;
import com.eg.yaofom.diner.servicereq.CreateDinerServiceReq;
import com.eg.yaofom.diner.servicereq.UpdateWorkingHoursServiceReq;
import com.eg.yaofom.diner.util.Req2ServiceReq;
import com.eg.yaofom.diner.util.ServiceResp2Resp;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/diner")
@RestController
public class DinerController {

    private final Req2ServiceReq req2ServiceReq;
    private final ServiceResp2Resp serviceResp2Resp;
    private final DinerService dinerService;

    public DinerController(Req2ServiceReq req2ServiceReq, ServiceResp2Resp serviceResp2Resp, DinerService dinerService) {
        this.req2ServiceReq = req2ServiceReq;
        this.serviceResp2Resp = serviceResp2Resp;
        this.dinerService = dinerService;
    }

    @RolesAllowed("ADMIN")
    @PostMapping
    public void createDiner(@RequestBody CreateDinerReq req){
        CreateDinerServiceReq serviceReq = req2ServiceReq.createDinerReq2CreateDinerServiceReq(req);
        dinerService.createDiner(serviceReq);
    }

    //@RolesAllowed("ADMIN")
    @PutMapping
    public void updateWorkingHours(@RequestBody UpdateWorkingHoursReq req){
        UpdateWorkingHoursServiceReq serviceReq = req2ServiceReq.updateWorkingHoursReq2UpdateWorkingHoursServiceReq(req);
        dinerService.updateWorkingHours(serviceReq);
    }

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
