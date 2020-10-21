package com.ximi.bean.scope.controller;

import com.ximi.bean.scope.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("application")
public class ApplicationScopeController {

    @Autowired
    @Qualifier("applicationUser")
    private User user;


    /**
     * 每一次请求的时候,user都会初始化和销毁
     *
     * @return
     */
    @GetMapping("/user")
    public String getUser() {
        return user.toString();
    }

}
