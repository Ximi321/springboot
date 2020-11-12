package com.ximi.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * 编码的文件资源
 *
 * @author Ximi
 * @since 2020/10/11
 */
public class EncodedFileSystemResourceDome {

    public static void main(String[] args) throws IOException {

        String currentFilePath = System.getProperty("user.dir") + "/src/main/java/com/ximi/resource/EncodeSystemFileResourceDome.java";
        FileSystemResource fileSystemResource = new FileSystemResource(currentFilePath);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");

        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }
    }

}
