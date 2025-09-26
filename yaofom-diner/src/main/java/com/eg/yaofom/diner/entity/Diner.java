package com.eg.yaofom.diner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
public class Diner extends BaseEntity {

    private String name;

    private String descr;

    private String address;

    private LocalTime beginHour;

    private LocalTime endHour;

    @Column(nullable = false)
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

    public LocalTime getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(LocalTime beginHour) {
        this.beginHour = beginHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    public Long getShopOwnerId() {
        return shopOwnerId;
    }

    public void setShopOwnerId(Long shopOwnerId) {
        this.shopOwnerId = shopOwnerId;
    }
}
