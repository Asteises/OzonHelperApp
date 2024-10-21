package ru.asteises.ozonhelperapp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.asteises.ozonhelperapp.common.client.ApiUri;
import ru.asteises.ozonhelperapp.common.client.ClientService;
import ru.asteises.ozonhelperapp.common.client.model.RestResponse;
import ru.asteises.ozonhelperapp.common.json.model.info.InfoValueRestResponse;
import ru.asteises.ozonhelperapp.common.json.model.price.PriceValueRestResponse;
import ru.asteises.ozonhelperapp.common.json.model.price.ProductItemRestResponse;
import ru.asteises.ozonhelperapp.common.json.model.request.OzonRestRequest;
import ru.asteises.ozonhelperapp.common.json.model.request.impl.DefaultFilterRestRequest;
import ru.asteises.ozonhelperapp.common.json.model.request.impl.DefaultRestRequest;
import ru.asteises.ozonhelperapp.common.json.model.request.impl.InfoProductRestRequest;
import ru.asteises.ozonhelperapp.common.json.service.JsonService;
import ru.asteises.ozonhelperapp.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ru.asteises.ozonhelperapp.common.client.ApiUri.*;


@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class ProductRestService implements ProductService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public InfoValueRestResponse getProductInfo(InfoProductRestRequest request) {
        String uri = ApiUri.getUri(VERSION_2, PRODUCT_INFO);
        String body = JsonService.getJsonFromObject(request, objectMapper);
        RestResponse response = ClientService.sendPostRequest(uri, body, restClient);
        if (response.isSuccess()) {
            return JsonService.parseJsonToDomain(response.getBody(), InfoValueRestResponse.class, objectMapper);
        }
        return null;
    }

    public PriceValueRestResponse getPrices(DefaultFilterRestRequest defaultFilterRestRequest) {
        String uri = ApiUri.getUri(VERSION_4, PRODUCT_INFO_PRICES);
        PriceValueRestResponse tempResult;
        List<ProductItemRestResponse> allPrices = new ArrayList<>();
        String lastId = null;

        do {
            OzonRestRequest<DefaultFilterRestRequest> request = DefaultRestRequest.builder()
                    .filter(defaultFilterRestRequest)
                    .limit(1000)
                    .lastId(lastId)
                    .build();

            String body = JsonService.getJsonFromObject(request, objectMapper);
            RestResponse response = ClientService.sendPostRequest(uri, body, restClient);

            if (!response.isSuccess()) {
                return null; // Если запрос не успешен, выходим
            }

            tempResult = JsonService
                    .parseJsonToDomain(response.getBody(), PriceValueRestResponse.class, objectMapper);

            allPrices.addAll(tempResult.getResult().getItems());
            lastId = tempResult.getResult().getLastId();

        } while (allPrices.size() < tempResult.getResult().getTotal());

        tempResult.getResult().setItems(allPrices);
        return tempResult;
    }

    public List<String> getNoMinimalPriceGoods(DefaultFilterRestRequest defaultFilterRestRequest) {
        PriceValueRestResponse tempResponse = getPrices(defaultFilterRestRequest);
        List<ProductItemRestResponse> itemsWithNoMinimalPrice = tempResponse.getResult().getItems().stream()
                .filter(item -> item.getPrice().getMinPrice().startsWith("0"))
                .toList();
        return itemsWithNoMinimalPrice.stream()
                .map(ProductItemRestResponse::getOfferId)
                .collect(Collectors.toList());
    }
}
