import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.SslContextSpec;
import reactor.netty.tcp.TcpClient;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Component
public class WebClientConfig {

    public WebClient createWebClient() throws SSLException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(new ClassPathResource("truststore.jks").getInputStream(), "changeit".toCharArray());

        SslContextSpec sslContextSpec = SslContextSpec.forClient().trustManager(trustStore);

        HttpClient httpClient = HttpClient.create().secure(sslContextSpec);

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
