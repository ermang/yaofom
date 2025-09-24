package com.eg.yaofom.order.req;

import java.util.List;

public class ReadCartResp {

    public List<ReadCartItemResp> cartItems;

    public ReadCartResp(List<ReadCartItemResp> cartItems) {
        this.cartItems = cartItems;
    }
}
