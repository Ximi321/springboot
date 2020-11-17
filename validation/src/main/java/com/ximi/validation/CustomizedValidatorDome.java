package com.ximi.validation;

import com.ximi.validation.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.Locale;

/**
 * 自定义 validator
 *
 * @author Ximi
 * @see Validator
 * @see UserValidator
 * @since 2020/11/17
 */
public class CustomizedValidatorDome {

    public static void main(String[] args) {

        User user = new User();
        UserValidator userValidator = new UserValidator();
        Errors errors = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, errors);

        MessageSource messageSource =  createMessageSource();
        for (ObjectError error : errors.getAllErrors()) {
            System.out.println("message:" + messageSource.getMessage(error.getCode(),error.getArguments(),Locale.getDefault()));
        }
    }

    public static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("name.required", Locale.getDefault(), "名字不能为空");
        messageSource.addMessage("age.required", Locale.getDefault(), "年龄不能为空");
        return messageSource;
    }

}
