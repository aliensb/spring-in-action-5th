package win.ccav.tacmal.utils;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

@Slf4j
public class HttpClientFactory {

    private static CloseableHttpClient client;

    public static HttpClient getHttpsClientSpeciel() throws Exception {

        if (client != null) {
            return client;
        }
        SSLContext sslcontext = getSSLContext();
        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslcontext,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        client = HttpClients.custom().setSSLSocketFactory(factory).build();

        return client;
    }


    public static HttpClient getHttpsClient() throws Exception {

        if (client != null) {
            return client;
        }
        SSLContext sslcontext = SSLContexts.custom().useSSL().build();
        sslcontext.init(null, new X509TrustManager[]{new HttpsTrustManager()}, new SecureRandom());
        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslcontext,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        client = HttpClients.custom().setSSLSocketFactory(factory).build();

        return client;
    }

    public static void releaseInstance() {
        client = null;
    }


    private static SSLContext getSSLContext() throws KeyStoreException,
            NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException {
        KeyStore trustStore  = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File("C:\\Users\\Administrator\\Downloads\\tacmal\\src\\main\\resources\\keystore.p12"));
        try {
            trustStore.load(instream, "a110120119".toCharArray());
        }catch (Exception e) {
            log.error("exception",e);
        }
        finally {
            instream.close();
        }
        return SSLContexts.custom()
                .loadTrustMaterial(trustStore)
                .build();
    }
}