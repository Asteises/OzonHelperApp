package ru.asteises.ozonhelperapp.common.client.model.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import ru.asteises.ozonhelperapp.common.client.model.RestResponse;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OzonRestResponse implements RestResponse {

    private String body;

    private HttpStatusCode statusCode;

    private String statusMessage;

    private String errorMessage;

    private HttpHeaders headers;

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public HttpHeaders getHeaders() {
        return headers;
    }

    @Override
    public boolean isSuccess() {
        return errorMessage == null || !errorMessage.trim().isEmpty();
    }

}
