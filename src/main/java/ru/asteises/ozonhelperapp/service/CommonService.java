package ru.asteises.ozonhelperapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestClient;
import ru.asteises.ozonhelperapp.common.client.ClientService;
import ru.asteises.ozonhelperapp.common.client.model.RequestParams;
import ru.asteises.ozonhelperapp.common.client.model.RestResponse;
import ru.asteises.ozonhelperapp.common.json.mapper.RequestMapper;
import ru.asteises.ozonhelperapp.common.json.model.request.impl.DefaultFilterRestRequest;
import ru.asteises.ozonhelperapp.common.json.model.request.impl.DefaultRestRequest;
import ru.asteises.ozonhelperapp.common.json.model.response.OzonRestResponse;
import ru.asteises.ozonhelperapp.common.json.model.response.OzonValueRestResponse;
import ru.asteises.ozonhelperapp.common.json.service.JsonService;

import java.util.ArrayList;
import java.util.List;

public interface CommonService {

    static <T extends OzonValueRestResponse<E>, E extends OzonRestResponse<H>, H> T getProductInfo(
            RequestParams params, String uri, Class<T> clazz, ObjectMapper objectMapper, RestClient restClient) {

        T responseValue;
        List<H> allProducts = new ArrayList<>();
        StringBuilder lastId = new StringBuilder();

        do {
            String body = getJsonBody(params, lastId.toString(), objectMapper);
            RestResponse response = ClientService.sendPostRequest(uri, body, restClient);

            responseValue = JsonService.parseJsonToDomain(response.getBody(), clazz, objectMapper);

            allProducts.addAll(responseValue.getResult().getItems());

            lastId.setLength(0);
            lastId.append(responseValue.getResult().getLastId());

        } while (allProducts.size() < responseValue.getResult().getTotal());

        return responseValue;
    }

    private static String getJsonBody(RequestParams params, String lastId, ObjectMapper objectMapper) {
        DefaultFilterRestRequest filter = RequestMapper.toDefaultFilterRequest(params);
        DefaultRestRequest request = RequestMapper.toDefaultRequest(filter, params, lastId);
        return JsonService.getJsonFromObject(request, objectMapper);
    }
}
