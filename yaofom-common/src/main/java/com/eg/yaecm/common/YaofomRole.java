package com.eg.yaecm.common;

public enum YaofomRole {
    USER("USER"),
    ADMIN("ADMIN"),
    SHOP_OWNER("SHOP_OWNER");

    private String value;

    private YaofomRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
