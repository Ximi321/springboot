package sun.net.www.protocol.ximi;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new XimiUrlConnection(u);
    }
}
