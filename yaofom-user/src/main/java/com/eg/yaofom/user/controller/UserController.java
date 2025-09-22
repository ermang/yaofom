package com.eg.yaofom.user.controller;

import com.eg.yaofom.user.req.LoginReq;
import com.eg.yaofom.user.service.UserService;
import com.eg.yaofom.user.servicereq.LoginServiceReq;
import com.eg.yaofom.user.util.Req2ServiceReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final Req2ServiceReq req2ServiceReq;
    private final UserService userService;

    public UserController(Req2ServiceReq req2ServiceReq, UserService userService) {
        this.req2ServiceReq = req2ServiceReq;
        this.userService = userService;
    }

    @PostMapping("/login")
    public String authenticate(@RequestBody LoginReq loginReq) {
        LoginServiceReq serviceReq = req2ServiceReq.loginReq2LoginServiceReq(loginReq);
        String token = userService.login(serviceReq);

        return token;
    }
}
