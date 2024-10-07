package ru.asteises.ozonhelperapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.asteises.ozonhelperapp.common.client.model.RequestParams;
import ru.asteises.ozonhelperapp.common.json.model.stock.response.StockValueRestResponse;
import ru.asteises.ozonhelperapp.service.impl.StockRestService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class StockRestServiceTest {

    @Autowired
    private StockRestService stockRestService;

    private RequestParams params;

    @Test
    @DisplayName("Возвращаем все товары в архиве")
    public void getProductInfoStocksTest() {
        params = RequestParams.builder()
                .visibility("ARCHIVED")
                .build();

        StockValueRestResponse actualResult = stockRestService.getProductInfoStocks(params);

        assertFalse(actualResult.getResult().getItems().isEmpty());
    }

    @Test
    @DisplayName("Возвращаем все товары в архиве с ненулевым остатком")
    public void getProductNotZeroQuantityStocksTest() {
        params = RequestParams.builder()
                .visibility("ARCHIVED")
                .build();

        Map<String, Map<String, Integer>> actualResult = stockRestService.getProductNotZeroQuantityStocks(params);

        assertFalse(actualResult.isEmpty());
    }
}
