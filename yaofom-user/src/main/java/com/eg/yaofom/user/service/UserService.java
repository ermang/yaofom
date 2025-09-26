package com.eg.yaofom.user.service;

import com.eg.yaofom.common.JwtUtil;
import com.eg.yaofom.user.entity.YaofomUser;
import com.eg.yaofom.user.repo.YaofomUserRepo;
import com.eg.yaofom.user.servicereq.LoginServiceReq;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JwtUtil jwtUtil;
    private final YaofomUserRepo yaofomUserRepo;

    public UserService(JwtUtil jwtUtil, YaofomUserRepo yaofomUserRepo) {
        this.jwtUtil = jwtUtil;
        this.yaofomUserRepo = yaofomUserRepo;
    }

    public String login(LoginServiceReq serviceReq) {
//    // Validate the user credentials here (username and password)
//    if ("user".equals(serviceReq.username) && "password".equals(serviceReq.password)) {
//        return jwtUtil.generateToken(serviceReq.username);
//    }
//    return "Invalid credentials!";

        YaofomUser yaofomUser = yaofomUserRepo.findByUsername(serviceReq.username);

        if (yaofomUser == null)
            throw new RuntimeException("hoppa");

        // Validate the user credentials here (username and password)
        if (yaofomUser.getPassword().equals(serviceReq.password)) {
            return jwtUtil.generateToken(serviceReq.username, yaofomUser.getYaecmRole(), yaofomUser.getId());
        }
        return "Invalid credentials!";
    }

}
