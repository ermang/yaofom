package com.eg.yaofom.user.entity;

import com.eg.yaecm.common.YaofomRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class YaofomUser extends BaseEntity {

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private YaofomRole yaofomRole;

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

    public YaofomRole getYaecmRole() {
        return yaofomRole;
    }

    public void setYaecmRole(YaofomRole yaofomRole) {
        this.yaofomRole = yaofomRole;
    }
}
