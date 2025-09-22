package com.eg.yaecm.user.entity;

import com.eg.yaecm.common.YaecmRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class YaecmUser extends BaseEntity {

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private YaecmRole yaecmRole;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public YaecmRole getYaecmRole() {
        return yaecmRole;
    }

    public void setYaecmRole(YaecmRole yaecmRole) {
        this.yaecmRole = yaecmRole;
    }
}
