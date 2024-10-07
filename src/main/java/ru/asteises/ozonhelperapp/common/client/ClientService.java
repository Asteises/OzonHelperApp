package ru.asteises.ozonhelperapp.common.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;
import ru.asteises.ozonhelperapp.common.client.model.RestResponse;
import ru.asteises.ozonhelperapp.common.client.model.impl.OzonRestResponse;

import java.io.IOException;
import java.net.URI;

public interface ClientService {

    Logger log = LoggerFactory.getLogger(ClientService.class);

    static RestResponse sendPostRequest(String uri, RestClient restClient) {

        return restClient.post()
                .uri(uri)
                .header("Content-Type", "application/json")
                .exchange((request, response) -> handleResponse(response, URI.create(uri)));
    }

    static RestResponse sendPostRequest(String uri, String body, RestClient restClient) {

        return restClient.post()
                .uri(uri)
                .body(body)
                .header("Content-Type", "application/json")
                .exchange((request, response) -> handleResponse(response, URI.create(uri)));
    }

    private static RestResponse handleResponse(RestClient.RequestHeadersSpec.ConvertibleClientHttpResponse response, URI uri) {
        try {

            if (response.getStatusCode().is2xxSuccessful()) {
                String body = response.bodyTo(String.class);
                return OzonRestResponse.builder()
                        .body(body)
                        .statusCode(response.getStatusCode())
                        .statusMessage(response.getStatusText())
                        .headers(response.getHeaders())
                        .build();
            } else {
                String errorMessage = response.bodyTo(String.class);

                log.error("Response error status: {}", response.getStatusCode());
                log.error("errorMessage: {}", errorMessage);

                return getErrorResponse(errorMessage, response.getStatusCode(), response.getStatusText());
            }
        } catch (IOException e) {
            log.error("IOException in process response handling: {}", e.getMessage());

            return getErrorResponse("Error while processing response: " + e.getMessage(), null, null);
        }
    }

    private static RestResponse getErrorResponse(String errorMessage, HttpStatusCode statusCode, String statusText) {
        return OzonRestResponse.builder()
                .errorMessage(errorMessage)
                .statusCode(statusCode)
                .statusMessage(statusText)
                .build();
    }
}
