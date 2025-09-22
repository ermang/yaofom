package com.eg.yaecm.user.util;

import com.eg.yaecm.user.req.LoginReq;
import com.eg.yaecm.user.servicereq.LoginServiceReq;
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
