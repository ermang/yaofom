package com.eg.yaofom.order.service;


import com.eg.yaofom.order.client.DinerClient;
import com.eg.yaofom.order.clientresp.ReadProductResp;
import com.eg.yaofom.order.entity.Cart;
import com.eg.yaofom.order.entity.OrderItem;
import com.eg.yaofom.order.entity.YaofomOrder;
import com.eg.yaofom.order.repo.CartRepo;
import com.eg.yaofom.order.repo.OrderItemRepo;
import com.eg.yaofom.order.repo.YaofomOrderRepo;
import com.eg.yaofom.order.servicereq.AddToCartServiceReq;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class OrderService {

    private final SecurityService securityService;
    //private final Entity2ServiceResp entity2ServiceResp;
    private final CartRepo cartRepo;
    private final YaofomOrderRepo yaofomOrderRepo;
    private final OrderItemRepo orderItemRepo;
    private final DinerClient dinerClient;

    public OrderService(SecurityService securityService, CartRepo cartRepo, YaofomOrderRepo yaofomOrderRepo,
                        OrderItemRepo orderItemRepo, DinerClient dinerClient) {
        this.securityService = securityService;
        this.cartRepo = cartRepo;
        this.yaofomOrderRepo = yaofomOrderRepo;
        this.orderItemRepo = orderItemRepo;
        this.dinerClient = dinerClient;
    }

    public void createOrder(Long userId) {
        List<Cart> cartList = cartRepo.findAllByUserId(userId);

        if (cartList.isEmpty())
            throw new RuntimeException("lolo");

        YaofomOrder yaofomOrder = new YaofomOrder();
        yaofomOrder.setUserId(userId);

        yaofomOrder = yaofomOrderRepo.save(yaofomOrder);

        for(Cart c : cartList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setYaofomOrder(yaofomOrder);
            orderItem.setProductId(c.getProductId());
            orderItem.setQuantity(c.getQuantity());
            ReadProductResp readProductResp = dinerClient.getProduct(c.getProductId());
            orderItem.setUnitPrice(readProductResp.price);
            orderItemRepo.save(orderItem);
        }

        cartRepo.deleteAllByUserId(userId);
    }

//    public void addToCart(AddToCartServiceReq serviceReq) {
//        Cart c = new Cart();
//        c.setProductId(serviceReq.productId);
//        c.setQuantity(serviceReq.quantity);
//        c.setUserId(serviceReq.userId);
//
//        cartRepo.save(c);
//    }





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
