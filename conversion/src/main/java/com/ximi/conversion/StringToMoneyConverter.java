package com.ximi.conversion;

import com.ximi.conversion.domain.Money;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * String 转化为 Money 的 Converter
 *
 * @author Ximi
 * @since 2020/11/20
 */
public class StringToMoneyConverter implements ConditionalGenericConverter {

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return String.class.equals(sourceType.getObjectType())
                && Money.class.equals(targetType.getObjectType());
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> set = new HashSet<>();
        ConvertiblePair pair = new ConvertiblePair(String.class, Money.class);
        set.add(pair);
        return set;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        String s = (String) source;
        try {
            String m[] = s.split(" ");
            if (m.length == 2) {
                Money money = new Money();
                money.setCurrency(m[0]);
                money.setAmount(BigDecimal.valueOf(Double.valueOf(m[1])));
                return money;
            }
        } catch (Exception ex) {

        }
        return null;
    }
}
