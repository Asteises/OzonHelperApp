package ru.asteises.ozonhelperapp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.asteises.ozonhelperapp.common.client.ApiUri;
import ru.asteises.ozonhelperapp.common.client.model.RequestParams;
import ru.asteises.ozonhelperapp.common.json.model.stock.response.StockItemRestResponse;
import ru.asteises.ozonhelperapp.common.json.model.stock.response.StockValueRestResponse;
import ru.asteises.ozonhelperapp.service.CommonService;
import ru.asteises.ozonhelperapp.service.StockService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.asteises.ozonhelperapp.common.client.ApiUri.PRODUCT_INFO_STOCKS;
import static ru.asteises.ozonhelperapp.common.client.ApiUri.VERSION_3;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockRestService implements StockService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public StockValueRestResponse getProductInfoStocks(@NonNull RequestParams params) {
        String uri = ApiUri.getUri(VERSION_3, PRODUCT_INFO_STOCKS);
        return CommonService.getProductInfo(
                params, uri, StockValueRestResponse.class, objectMapper, restClient
        );
    }

    public Map<String, Map<String, Integer>> getProductNotZeroQuantityStocks(@NonNull RequestParams params) {
        List<StockItemRestResponse> stockItems = getProductInfoStocks(params).getResult().getItems();
        Map<String, Map<String, Integer>> result = new HashMap<>();
        for (var item : stockItems) {
            Map<String, Integer> quantityByType = new HashMap<>();
            for (var node : item.getStocks()) {
                if (node.getPresent() > 0) {
                    quantityByType.put(node.getType(), node.getPresent());
                }
            }
            if (!quantityByType.isEmpty()) {
                result.put(item.getOfferId(), quantityByType);
            }
        }
        return result;
    }
}
