package ru.asteises.ozonhelperapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.asteises.ozonhelperapp.common.client.ApiUri;
import ru.asteises.ozonhelperapp.common.client.model.RequestParams;
import ru.asteises.ozonhelperapp.common.json.model.price.PriceValueRestResponse;

import static ru.asteises.ozonhelperapp.common.client.ApiUri.PRODUCT_INFO_PRICES;
import static ru.asteises.ozonhelperapp.common.client.ApiUri.VERSION_4;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceRestService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public PriceValueRestResponse getProductInfoPrices(@NonNull RequestParams params) {
        String uri = ApiUri.getUri(VERSION_4, PRODUCT_INFO_PRICES);
        return CommonService.getProductInfo(
                params, uri, PriceValueRestResponse.class, objectMapper, restClient
        );
    }

}
