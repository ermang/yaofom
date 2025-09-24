package com.eg.yaofom.order.servicereq;

import com.eg.yaofom.order.req.ReadCartItemResp;

import java.util.ArrayList;
import java.util.List;

public class ReadCartServiceResp {

    public List<ReadCartItemResp> cartItems;

    public ReadCartServiceResp() {
        this.cartItems = new ArrayList<>();
    }
}
