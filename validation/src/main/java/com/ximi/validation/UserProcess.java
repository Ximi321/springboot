package com.ximi.validation;

import com.ximi.validation.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * User process
 *
 * @author Ximi
 * @since 2020/11/17
 */
@Component
@Validated
public class UserProcess {

    public void process(@Valid User user) {
        System.out.println("user" + user);
    }

}
