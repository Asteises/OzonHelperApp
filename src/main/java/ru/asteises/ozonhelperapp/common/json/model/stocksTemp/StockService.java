package ru.asteises.ozonhelperapp.common.json.model.stocksTemp;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.asteises.ozonhelperapp.common.client.ClientService;
import ru.asteises.ozonhelperapp.common.client.model.RequestParams;
import ru.asteises.ozonhelperapp.common.client.model.RestResponse;
import ru.asteises.ozonhelperapp.common.json.model.stocksTemp.request.StockFilterRestRequest;
import ru.asteises.ozonhelperapp.common.json.model.stocksTemp.request.StockRestRequest;
import ru.asteises.ozonhelperapp.common.json.model.stocksTemp.response.StockItemRestResponse;
import ru.asteises.ozonhelperapp.common.json.model.stocksTemp.response.StockValueRestResponse;
import ru.asteises.ozonhelperapp.common.json.service.JsonService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.asteises.ozonhelperapp.common.client.ApiUri.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockService {

    private final JsonService jsonService;
    private final ClientService clientService;

    public Map<String, Integer> getProductInfoStocks(@NonNull RequestParams params) {
        StringBuilder lastId = new StringBuilder();
        StockValueRestResponse responseValue;
        List<StockItemRestResponse> resultProducts = new ArrayList<>();
        do {
            StockFilterRestRequest filter = StockFilterRestRequest.builder()
                    .offerIds(params.getOfferIds())
                    .productIds(params.getProductIds())
                    .visibility(params.getVisibility().isEmpty() ? "ALL" : params.getVisibility())
                    .build();

            StockRestRequest request = StockRestRequest.builder()
                    .filter(filter)
                    .limit(params.getLimit() == null ? 100 : params.getLimit())
                    .lastId(lastId.toString())
                    .build();

            String body = jsonService.getJsonFromObject(request);

            String uri = getUri(VERSION_3, PRODUCT_INFO_STOCKS);

            RestResponse response = clientService.sendPostRequest(uri, body);


            responseValue = jsonService.parseJsonToDomain(response.getBody(), StockValueRestResponse.class);
            resultProducts.addAll(responseValue.getResult().getItems());

            lastId.setLength(0);
            lastId.append(responseValue.getResult().getLastId());

        } while (resultProducts.size() < responseValue.getResult().getTotal());

        Map<String, Integer> result = new HashMap<>();
        for (var item : resultProducts) {
            for (var node : item.getStocks()) {
                if (node.getPresent() > 0) {
                    result.put(item.getOfferId(), node.getPresent());
                }
            }
        }
        return result;
    }
}
