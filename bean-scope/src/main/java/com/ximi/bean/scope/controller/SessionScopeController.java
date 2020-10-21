package com.ximi.bean.scope.controller;

import com.ximi.bean.scope.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("session")
public class SessionScopeController {

    @Autowired
    @Qualifier("sessionUser")
    private User user;

    /**
     * 同一个session中 user 是同一个
     *
     * @return
     */
    @GetMapping("/user")
    public String getUser() {
        return user.toString();
    }

}
