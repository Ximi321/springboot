package com.ximi.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * 编码的文件系统加载
 *
 * @author Ximi
 * @since 2020/11/10
 */
public class EncodedFileSystemResourceLoaderDome {

    public static void main(String[] args) throws IOException {

        String currentFilePath = System.getProperty("user.dir") + "/src/main/java/com/ximi/resource/EncodedFileSystemResourceLoaderDome.java";

        FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource(currentFilePath);

        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
        try (Reader reader = encodedResource.getReader()){
            System.out.println(IOUtils.toString(reader));
        }
    }

}
