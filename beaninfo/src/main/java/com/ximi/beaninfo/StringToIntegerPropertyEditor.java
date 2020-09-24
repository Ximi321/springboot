package com.ximi.beaninfo;

import java.beans.PropertyEditorSupport;

public class StringToIntegerPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Integer value = Integer.valueOf(text);
        setValue(value);
    }
}
