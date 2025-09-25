package com.eg.yaofom.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class YaofomOrder extends BaseEntity {

    @Column(nullable = false)
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
