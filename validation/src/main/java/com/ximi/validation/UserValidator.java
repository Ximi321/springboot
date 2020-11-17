package com.ximi.validation;

import com.ximi.validation.domain.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 用户校验器
 *
 * @author Ximi
 * @since 2020/11、17
 */
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(!StringUtils.hasText(user.getName())){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.required");
        }

        if(user.getAge() == null){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"age","age.required");
        }
    }
}
