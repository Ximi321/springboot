package com.ximi.i18n;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 *{@link java.text.MessageFormat} 用例
 *
 */
public class MessageFormatDome {

    public static void main(String[] args) {

        String patter = "one is {0},two is {1,date},three is {2,number,integer}";
        MessageFormat messageFormat = new MessageFormat(patter);
        String result = messageFormat.format(new Object[]{"helloworld",new Date(),30}).toString();
        System.out.println("result: " + result);

        //reset patter
        patter = "one is {0},two is {1,date}";
        messageFormat.applyPattern(patter);
        result = messageFormat.format(new Object[]{"helloworld",new Date(),30}).toString();
        System.out.println("result: " + result);

        patter = "one is {0},two is {1,date},three is {2,number,integer}";
        messageFormat.setLocale(Locale.ENGLISH);
        messageFormat.applyPattern(patter);
        result = messageFormat.format(new Object[]{"helloworld",new Date(),30}).toString();
        System.out.println("result: " + result);

        patter = "one is {0},two is {1,date},three is {2,number,integer}";
        messageFormat.setLocale(Locale.ENGLISH);
        messageFormat.applyPattern(patter);
        messageFormat.setFormat(1,new SimpleDateFormat("yyyy-MM-dd"));
        result = messageFormat.format(new Object[]{"helloworld",new Date(),30}).toString();
        System.out.println("result: " + result);
    }


}
