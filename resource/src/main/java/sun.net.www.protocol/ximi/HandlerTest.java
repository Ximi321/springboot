package sun.net.www.protocol.ximi;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HandlerTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("ximi:///MTEA-INF//application.properties");
        InputStream inputStream = url.openStream();
        System.out.println(IOUtils.toString(inputStream, "UTF-8"));
    }

}
