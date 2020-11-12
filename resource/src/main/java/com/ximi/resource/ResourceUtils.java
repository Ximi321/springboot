package com.ximi.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * Resource 工具
 *
 * @author Ximi
 * @since 2020/11/10
 */
public class ResourceUtils {

    public static String getContext(Resource resource){

        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
        try(Reader reader = encodedResource.getReader()) {
            return IOUtils.toString(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
