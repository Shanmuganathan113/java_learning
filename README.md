import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiService {

    private static final String API_KEY_HEADER = "X-API-KEY";
    private static final String API_KEY = "your-secret-api-key";
    private static final String BASE_URL = "http://localhost:8080/api"; // Change to your base URL

    @Autowired
    private WebClient webClient;

    public Mono<String> getSecuredData() {
        return webClient.get()
                .uri(BASE_URL + "/data")
                .header(API_KEY_HEADER, API_KEY)
                .retrieve()
                .bodyToMono(String.class);
    }
}
