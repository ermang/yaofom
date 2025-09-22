package com.eg.yaofom.diner.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Diner extends BaseEntity {

    private String name;

    private String descr;

    private String address;

    private Long shopOwnerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getShopOwnerId() {
        return shopOwnerId;
    }

    public void setShopOwnerId(Long shopOwnerId) {
        this.shopOwnerId = shopOwnerId;
    }
}
