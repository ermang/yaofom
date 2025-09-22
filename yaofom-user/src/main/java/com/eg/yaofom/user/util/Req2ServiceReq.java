package com.eg.yaofom.user.util;

import com.eg.yaofom.user.req.LoginReq;
import com.eg.yaofom.user.servicereq.LoginServiceReq;
import org.springframework.stereotype.Component;

@Component
public class Req2ServiceReq {


    public LoginServiceReq loginReq2LoginServiceReq(LoginReq req) {
        LoginServiceReq serviceReq = new LoginServiceReq();
        serviceReq.username = req.username;
        serviceReq.password = req.password;

        return serviceReq;
    }
}
