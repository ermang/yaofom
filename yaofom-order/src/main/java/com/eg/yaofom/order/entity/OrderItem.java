package com.eg.yaofom.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem extends BaseEntity {

    @ManyToOne(optional = false)
    private YaofomOrder yaofomOrder;

    public YaofomOrder getOrder() {
        return yaofomOrder;
    }

    public void setOrder(YaofomOrder yaofomOrder) {
        this.yaofomOrder = yaofomOrder;
    }
}
