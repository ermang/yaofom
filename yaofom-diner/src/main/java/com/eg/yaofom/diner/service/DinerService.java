package com.eg.yaofom.diner.service;

import com.eg.yaofom.diner.entity.Diner;
import com.eg.yaofom.diner.repo.DinerRepo;
import com.eg.yaofom.diner.servicereq.CreateDinerServiceReq;
//import com.eg.yaofom.diner.util.Entity2ServiceResp;
import com.eg.yaofom.diner.serviceresp.ValidateOwnerServiceResp;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DinerService {

    private final SecurityService securityService;
    //private final Entity2ServiceResp entity2ServiceResp;
    private final DinerRepo dinerRepo;

    public DinerService(SecurityService securityService, DinerRepo dinerRepo) {
        this.securityService = securityService;
        this.dinerRepo = dinerRepo;
    }

    public void createDiner(CreateDinerServiceReq serviceReq) {
        Diner d = new Diner();

        d.setName(serviceReq.name);
        d.setDescr(serviceReq.descr);
        d.setAddress(serviceReq.address);
        d.setShopOwnerId(serviceReq.userId);

        dinerRepo.save(d);
    }

    public ValidateOwnerServiceResp validateOwner(Long dinerId) {
        securityService.getUserId();

        Optional<Diner> optionalD = dinerRepo.findById(dinerId);

        if (optionalD.isEmpty())
            throw new RuntimeException("lolo");

        if (optionalD.get().getShopOwnerId().equals(securityService.getUserId()))
            return new ValidateOwnerServiceResp(true);
        else
            return new ValidateOwnerServiceResp(false);
    }

//    public ReadProductServiceResp getProduct(long id) {
//
//        Optional<Product> optionalP = dinerRepo.findById(id);
//
//        if (optionalP.isEmpty())
//            throw new YaecmException("");
//
//        Product p = optionalP.get();
//        ReadProductServiceResp serviceResp = entity2ServiceResp.product2ReadProductServiceResp(p);
//
//        return serviceResp;
//    }
}
