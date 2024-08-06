import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.SslProvider;

import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class WebClientConfig {

    @Bean
    public WebClient configureRestTemplate(WebClient.Builder builder) {
        logger.info("Setting up rest template...");
        WebClient webClient = null;

        try {
            // Load the keystore
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            try (FileInputStream keyStoreStream = new FileInputStream("path/to/keystore")) {
                keyStore.load(keyStoreStream, "changeme".toCharArray());
            }

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sslContext.init(null, trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());

            webClient = builder
                    .baseUrl("YOUR_BASE_URL_HERE")
                    .clientConnector(new ReactorClientHttpConnector(HttpClient.create()
                        .secure(sslContextSpec -> sslContextSpec.sslContext(sslContext))))
                    .build();

            logger.info("Rest template configured successfully...");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return webClient;
    }
}
