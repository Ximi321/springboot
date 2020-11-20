package com.ximi.conversion;

import com.ximi.conversion.domain.Money;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;


/**
 * 自定义 {@link PropertyEditorRegistrar}
 *
 * @author Ximi
 * @since 2020/11/19
 */
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {

        registry.registerCustomEditor(Money.class, new MoneyPropertyEditor());
    }
}
