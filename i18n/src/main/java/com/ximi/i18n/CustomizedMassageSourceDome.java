package com.ximi.i18n;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 自定义 {@link MessageSource}
 *
 * @author Ximi
 * @see AbstractApplicationContext#initMessageSource()
 * @see MessageSourceAutoConfiguration
 * @since 2020/11/16
 */
@EnableAutoConfiguration
public class CustomizedMassageSourceDome {

    @Bean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
    public MessageSource messageSource() {
        return new ReloadableResourceBundleMessageSource();
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(CustomizedMassageSourceDome.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MessageSource messageSource = context.getBean(MessageSource.class);
        if (null != messageSource) {
            System.out.println("messageSource:" + messageSource);
        }

        context.close();

    }

}
