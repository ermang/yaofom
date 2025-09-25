package com.eg.yaofom.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class OrderItem extends BaseEntity {

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Integer quantity;


    @Column(nullable = false)
    private BigDecimal unitPrice;

    @ManyToOne(optional = false)
    private YaofomOrder yaofomOrder;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public YaofomOrder getYaofomOrder() {
        return yaofomOrder;
    }

    public void setYaofomOrder(YaofomOrder yaofomOrder) {
        this.yaofomOrder = yaofomOrder;
    }
}
