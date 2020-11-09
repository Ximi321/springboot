package com.ximi.configuration.metadata;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

/**
 * 定义
 *
 * @author Ximi
 * @since 2020/11/09
 */
public class YamlPropertiesSourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean yamlMapFactoryBean = new YamlPropertiesFactoryBean();
        yamlMapFactoryBean.setResources(resource.getResource());
        PropertySource propertySource = new PropertiesPropertySource(name, yamlMapFactoryBean.getObject());
        return propertySource;
    }
}
