package com.eg.yaofom.order.service;


import com.eg.yaofom.order.entity.Cart;
import com.eg.yaofom.order.repo.CartRepo;
import com.eg.yaofom.order.servicereq.AddToCartServiceReq;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final SecurityService securityService;
    //private final Entity2ServiceResp entity2ServiceResp;
    private final CartRepo cartRepo;

    public OrderService(SecurityService securityService, CartRepo cartRepo) {
        this.securityService = securityService;
        this.cartRepo = cartRepo;
    }

//    public void addToCart(AddToCartServiceReq serviceReq) {
//        Cart c = new Cart();
//        c.setProductId(serviceReq.productId);
//        c.setQuantity(serviceReq.quantity);
//        c.setUserId(serviceReq.userId);
//
//        cartRepo.save(c);
//    }

    public void createOrder() {

    }

//    public void createDiner(CreateDinerServiceReq serviceReq) {
//        Diner d = new Diner();
//
//        d.setName(serviceReq.name);
//        d.setDescr(serviceReq.descr);
//        d.setAddress(serviceReq.address);
//        d.setShopOwnerId(serviceReq.userId);
//
//        dinerRepo.save(d);
//    }
//
//    public ValidateOwnerServiceResp validateOwner(Long dinerId) {
//        securityService.getUserId();
//
//        Optional<Diner> optionalD = dinerRepo.findById(dinerId);
//
//        if (optionalD.isEmpty())
//            throw new RuntimeException("lolo");
//
//        if (optionalD.get().getShopOwnerId().equals(securityService.getUserId()))
//            return new ValidateOwnerServiceResp(true);
//        else
//            return new ValidateOwnerServiceResp(false);
//    }

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
