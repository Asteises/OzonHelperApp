package ru.asteises.ozonhelperapp.common.client.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.asteises.ozonhelperapp.common.client.ClientService;
import ru.asteises.ozonhelperapp.common.client.model.RestResponse;
import ru.asteises.ozonhelperapp.common.client.model.impl.OzonRestResponse;

import java.io.IOException;
import java.net.URI;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final RestClient restClient;

    @Override
    public RestResponse sendPostRequest(String uri) {

        return restClient.post()
                .uri(uri)
                .header("Content-Type", "application/json")
                .exchange((request, response) -> handleResponse(response, URI.create(uri)));
    }

    @Override
    public RestResponse sendPostRequest(String uri, String body) {

        return restClient.post()
                .uri(uri)
                .body(body)
                .header("Content-Type", "application/json")
                .exchange((request, response) -> handleResponse(response, URI.create(uri)));
    }

    private RestResponse handleResponse(RestClient.RequestHeadersSpec.ConvertibleClientHttpResponse response, URI uri) {
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

    private RestResponse getErrorResponse(String errorMessage, HttpStatusCode statusCode, String statusText) {
        return OzonRestResponse.builder()
                .errorMessage(errorMessage)
                .statusCode(statusCode)
                .statusMessage(statusText)
                .build();
    }
}
