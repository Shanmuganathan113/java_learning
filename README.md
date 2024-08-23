import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.web.server.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.server.WebSessionServerOAuth2AuthorizedClientRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder(ServerOAuth2AuthorizedClientManager authorizedClientManager) {
        return WebClient.builder()
            .apply(oauth2Configuration(authorizedClientManager));
    }

    @Bean
    public ServerOAuth2AuthorizedClientManager authorizedClientManager(
            ServerOAuth2AuthorizedClientRepository authorizedClientRepository) {
        ServerOAuth2AuthorizedClientProvider authorizedClientProvider =
                ServerOAuth2AuthorizedClientProviderBuilder.builder()
                        .authorizationCode()
                        .refreshToken()
                        .build();

        return new DefaultOAuth2AuthorizedClientManager(
                authorizedClientRepository,
                authorizedClientProvider
        );
    }

    @Bean
    public ServerOAuth2AuthorizedClientRepository authorizedClientRepository() {
        return new WebSessionServerOAuth2AuthorizedClientRepository();
    }

    private Consumer<WebClient.Builder> oauth2Configuration(
            ServerOAuth2AuthorizedClientManager authorizedClientManager) {
        return builder -> builder
            .apply(ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2Configuration(authorizedClientManager));
    }
}
