package ru.asteises.ozonhelperapp.common.client.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;


public interface RestResponse {

    String getBody();

    HttpStatusCode getStatusCode();

    String getStatusMessage();

    String getErrorMessage();

    HttpHeaders getHeaders();

    boolean isSuccess();
}
