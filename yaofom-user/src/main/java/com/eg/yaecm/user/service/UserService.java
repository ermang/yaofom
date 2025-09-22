package com.eg.yaecm.user.service;

import com.eg.yaecm.user.config.JwtUtil;
import com.eg.yaecm.user.entity.YaecmUser;
import com.eg.yaecm.user.repo.YaecmUserRepo;
import com.eg.yaecm.user.servicereq.LoginServiceReq;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JwtUtil jwtUtil;
    private final YaecmUserRepo yaecmUserRepo;

    public UserService(JwtUtil jwtUtil, YaecmUserRepo yaecmUserRepo) {
        this.jwtUtil = jwtUtil;
        this.yaecmUserRepo = yaecmUserRepo;
    }

    public String login(LoginServiceReq serviceReq) {
//    // Validate the user credentials here (username and password)
//    if ("user".equals(serviceReq.username) && "password".equals(serviceReq.password)) {
//        return jwtUtil.generateToken(serviceReq.username);
//    }
//    return "Invalid credentials!";

        YaecmUser yaecmUser = yaecmUserRepo.findByUsername(serviceReq.username);

        if (yaecmUser == null)
            throw new RuntimeException("hoppa");

        // Validate the user credentials here (username and password)
        if (yaecmUser.getPassword().equals(serviceReq.password)) {
            return jwtUtil.generateToken(serviceReq.username, yaecmUser.getYaecmRole());
        }
        return "Invalid credentials!";
    }

}
