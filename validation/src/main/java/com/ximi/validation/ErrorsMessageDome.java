package com.ximi.validation;

import com.ximi.validation.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * {@link Errors} 用例
 *
 * @author Ximi
 * @since 2020/11/17
 */
public class ErrorsMessageDome {

    public static void main(String[] args) {

        User user = new User();
        Errors errors = new BeanPropertyBindingResult(user, "user");
        errors.reject("user.properties.not.null");
        errors.rejectValue("name", "name.required");
        List<ObjectError> allErrors = errors.getAllErrors();

        MessageSource messageSource = createMessageSource();

        for (ObjectError error : allErrors) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println("message:" + message);
        }
    }

    public static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("user.properties.not.null", Locale.getDefault(), "类字段不能为空");
        messageSource.addMessage("name.required", Locale.getDefault(), "名字不能为空");
        return messageSource;
    }
}
