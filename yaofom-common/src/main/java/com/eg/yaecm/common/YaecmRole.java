package com.eg.yaecm.common;

public enum YaecmRole {
    USER("USER"),
    ADMIN("ADMIN"),
    SHOP_OWNER("SHOP_OWNER");

    private String value;

    private YaecmRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
