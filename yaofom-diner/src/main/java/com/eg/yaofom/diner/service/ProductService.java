package com.eg.yaofom.diner.service;


import com.eg.yaecm.common.YaecmException;
import com.eg.yaofom.diner.entity.Diner;
import com.eg.yaofom.diner.entity.Product;
import com.eg.yaofom.diner.repo.DinerRepo;
import com.eg.yaofom.diner.repo.ProductRepo;
import com.eg.yaofom.diner.servicereq.CreateProductServiceReq;
import com.eg.yaofom.diner.serviceresp.ReadProductServiceResp;
import com.eg.yaofom.diner.util.Entity2ServiceResp;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final Entity2ServiceResp entity2ServiceResp;
    private final ProductRepo productRepo;
    private final DinerRepo dinerRepo;
//    private final DinerClient dinerClient;


    public ProductService(Entity2ServiceResp entity2ServiceResp, ProductRepo productRepo, DinerRepo dinerRepo) {
        this.entity2ServiceResp = entity2ServiceResp;
        this.productRepo = productRepo;
        this.dinerRepo = dinerRepo;
    }

    public void createProduct(CreateProductServiceReq serviceReq) {
        Product p = new Product();

        p.setName(serviceReq.name);
        p.setDescr(serviceReq.description);
        p.setPrice(serviceReq.price);



//        ValidateOwnerClientResp clientResp = dinerClient.validateOwner(serviceReq.dinerId);
//        if (clientResp.valid == false)
//            throw new RuntimeException("aman");

        Diner d = dinerRepo.findById(serviceReq.dinerId).get();
        p.setDiner(d);

        productRepo.save(p);
    }

    public ReadProductServiceResp getProduct(long id) {

        Optional<Product> optionalP = productRepo.findById(id);

        if (optionalP.isEmpty())
            throw new YaecmException("");

        Product p = optionalP.get();
        ReadProductServiceResp serviceResp = entity2ServiceResp.product2ReadProductServiceResp(p);

        return serviceResp;
    }
}
