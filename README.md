import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public class WebClientLoggingFilter {

    private static final Logger LOGGER = Logger.getLogger(WebClientLoggingFilter.class.getName());

    public static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
            logRequestDetails(request);
            return Mono.just(request);
        });
    }

    public static ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(response -> {
            logResponseDetails(response);
            return Mono.just(response);
        });
    }

    private static void logRequestDetails(ClientRequest request) {
        LOGGER.info("Request: " + request.method() + " " + request.url());
        request.headers().forEach((name, values) -> values.forEach(value -> LOGGER.info(name + ": " + value)));
    }

    private static void logResponseDetails(ClientResponse response) {
        LOGGER.info("Response status: " + response.statusCode());
        response.headers().asHttpHeaders().forEach((name, values) -> values.forEach(value -> LOGGER.info(name + ": " + value)));
    }
}
