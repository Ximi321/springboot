package sun.net.www.protocol.ximi;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class XimiUrlConnection extends URLConnection {

    private ClassPathResource classPathResource;

    /**
     * Constructs a URL connection to the specified URL. A connection to
     * the object referenced by the URL is not created.
     *
     * @param url the specified URL.
     */
    protected XimiUrlConnection(URL url) {
        super(url);
        classPathResource = new ClassPathResource(url.getPath());
    }

    @Override
    public void connect() throws IOException {

    }

    @Override
    public InputStream getInputStream() throws IOException {
        return classPathResource.getInputStream();
    }
}
