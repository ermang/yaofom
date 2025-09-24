package com.eg.yaofom.order.service;


import com.eg.yaofom.order.entity.Cart;
import com.eg.yaofom.order.repo.CartRepo;
import com.eg.yaofom.order.req.ReadCartItemResp;
import com.eg.yaofom.order.servicereq.AddToCartServiceReq;
import com.eg.yaofom.order.servicereq.ReadCartServiceResp;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServive {

    private final SecurityService securityService;
    //private final Entity2ServiceResp entity2ServiceResp;
    private final CartRepo cartRepo;

    public CartServive(SecurityService securityService, CartRepo cartRepo) {
        this.securityService = securityService;
        this.cartRepo = cartRepo;
    }

    public void addToCart(AddToCartServiceReq serviceReq) {
        Cart c = new Cart();
        c.setProductId(serviceReq.productId);
        c.setQuantity(serviceReq.quantity);
        c.setUserId(serviceReq.userId);

        cartRepo.save(c);
    }

    public ReadCartServiceResp readCart() {
        Long userId = securityService.getUserId();

        List<Cart> cartList = cartRepo.findAllByUserId(userId);
        ReadCartServiceResp readCartServiceResp = new ReadCartServiceResp();

        for(Cart c : cartList) {
            ReadCartItemResp cartItemResp = new ReadCartItemResp();
            cartItemResp.price =  BigDecimal.ZERO;
            cartItemResp.productId = c.getProductId();
            cartItemResp.quantity = c.getQuantity();
            readCartServiceResp.cartItems.add(cartItemResp);
        }

        return readCartServiceResp;
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
