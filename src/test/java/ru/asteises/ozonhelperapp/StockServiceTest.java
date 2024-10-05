package ru.asteises.ozonhelperapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.asteises.ozonhelperapp.common.client.model.RequestParams;
import ru.asteises.ozonhelperapp.common.json.model.stocksTemp.StockService;
import ru.asteises.ozonhelperapp.common.json.model.stocksTemp.response.StockItemRestResponse;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StockServiceTest {

    @Autowired
    private StockService stockService;

    @Test
    public void getProductInfoStocksTest() {

        RequestParams params = RequestParams.builder()
                .visibility("ARCHIVED")
                .build();

        Map<String, Integer> actualResult = stockService.getProductInfoStocks(params);

        assertEquals(72, actualResult.size());
    }
}
