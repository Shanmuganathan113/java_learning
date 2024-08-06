import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class WebClientConfig {

    @Bean
    public WebClient configureRestTemplate(WebClient.Builder builder) {
        logger.info("Setting up rest template...");
        String[] versions = {"TLSv1.2"};
        WebClient webClient = null;

        try {
            // Load the truststore
            KeyStore trustStore = KeyStore.getInstance("PKCS12");
            try (FileInputStream trustStoreStream = new FileInputStream(propertyManager.getProperty("KEY_TRUST_PATH_HCP"))) {
                trustStore.load(trustStoreStream, propertyManager.getProperty("TRUST_STORE_PASS").toCharArray());
            }

            // Load the keystore
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            try (FileInputStream keyStoreStream = new FileInputStream(propertyManager.getProperty("KEY_TRUST_PATH_HCP"))) {
                keyStore.load(keyStoreStream, propertyManager.getProperty("TRUST_STORE_PASS").toCharArray());
            }

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);

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
