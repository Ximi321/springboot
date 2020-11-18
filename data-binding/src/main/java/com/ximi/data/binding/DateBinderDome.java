package com.ximi.data.binding;

import com.ximi.data.binding.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * {@link DataBinder} 用例
 *
 * @author Ximi
 * @since 2020/11/18
 */
public class DateBinderDome {

    public static void main(String[] args) {

        User user = new User();
        DataBinder dataBinder = new DataBinder(user);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("name","ximi");
        propertyValues.add("age",30);
        propertyValues.add("address.stress","sz");

        //忽略未知属性,默认是true
//        dataBinder.setIgnoreUnknownFields(false);
//        propertyValues.add("id","1");

        //忽略非法字段默认是false,
        //是否自动生成嵌套路径的对象,默认是true
//        dataBinder.setIgnoreInvalidFields(false);
//        dataBinder.setAutoGrowNestedPaths(false);
//        user.setAddress(new Address());

//        dataBinder.setRequiredFields("name","age");

//        //设置白名单
//        dataBinder.setAllowedFields("age","address.stress");
//        //设置黑名单
//        dataBinder.setDisallowedFields("name"); //

        dataBinder.bind(propertyValues);

        BindingResult result = dataBinder.getBindingResult();
        List<ObjectError> list = result.getAllErrors();

        list.forEach(System.out::println);
        System.out.println("user:" + user);
    }

}
