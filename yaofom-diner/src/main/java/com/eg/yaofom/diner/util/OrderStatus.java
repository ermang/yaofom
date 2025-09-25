package com.eg.yaofom.diner.util;

public enum OrderStatus {
    INITIAL("INITIAL"),
    WAITING_PAYMENT("WAITING_PAYMENT"),
    COMPLETED("COMPLETED");

    private String value;

    private OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
