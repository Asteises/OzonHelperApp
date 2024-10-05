package ru.asteises.ozonhelperapp.common.client;

import ru.asteises.ozonhelperapp.common.client.model.RestResponse;

public interface ClientService {

    RestResponse sendPostRequest(String uri);

    RestResponse sendPostRequest(String uri, String body);
}
