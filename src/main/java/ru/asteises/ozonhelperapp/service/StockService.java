package ru.asteises.ozonhelperapp.service;

import lombok.NonNull;
import ru.asteises.ozonhelperapp.common.client.model.RequestParams;
import ru.asteises.ozonhelperapp.common.json.model.stock.response.StockValueRestResponse;

import java.util.Map;

public interface StockService {

    /*
    Возвращает информацию о количестве товаров на складах.
     */
    StockValueRestResponse getProductInfoStocks(@NonNull RequestParams params);

    /*
    Возвращает информацию о количестве товаров на складах для товаров с ненулевым остатком.
    */
    Map<String, Map<String, Integer>> getProductNotZeroQuantityStocks(@NonNull RequestParams params);

}
