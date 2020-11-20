package com.ximi.conversion;

import com.ximi.conversion.domain.Money;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;

/**
 * Money 类型的 PropertyEditor
 *
 * @author Ximi
 * @since 2020/11/19
 */
public class MoneyPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        text = text.trim();
        String[] s = text.split(" ");
        if (s.length != 2) {
            throw new IllegalArgumentException("money format " + text + "illegal");
        }

        try {
            Money money = new Money();
            money.setCurrency(s[0]);
            money.setAmount(BigDecimal.valueOf(Double.valueOf(s[1])));
            setValue(money);
        } catch (Exception ex) {
            throw new IllegalArgumentException("money format " + text + "illegal");
        }
    }

    @Override
    public String getAsText() {
        Money money = (Money) getValue();
        return money.getCurrency() + " " + money.getAmount();
    }
}
