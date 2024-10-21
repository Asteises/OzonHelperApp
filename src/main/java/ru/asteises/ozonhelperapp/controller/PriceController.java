package ru.asteises.ozonhelperapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.asteises.ozonhelperapp.common.json.model.price.PriceValueRestResponse;
import ru.asteises.ozonhelperapp.common.json.model.request.impl.DefaultFilterRestRequest;
import ru.asteises.ozonhelperapp.service.impl.ProductRestService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PriceController {

    private final ProductRestService productRestService;

    /**
     * Получаем информацию о цене товаров.
     * Реализация стандартного метода из Ozon API: /v4/product/info/prices
     * Если не указываем конкретные артикулы, то возвращаем все товары в зависимости от visibility.
     * @param defaultFilterRestRequest - стандартный фильтр запрос для Ozon API.
     * @param synchronize - указание для синхронизации с БД: SAVE
     */
    //TODO - принимать нужно любую реализацию интерфейса
    @PostMapping("/product/info/prices")
    public ResponseEntity<PriceValueRestResponse> getPrices(
            @RequestBody DefaultFilterRestRequest defaultFilterRestRequest,
            @RequestParam String synchronize) {

        log.info("all prices request: {}", defaultFilterRestRequest);
        log.info("synchronize: {}", synchronize);
        PriceValueRestResponse response = productRestService.getPrices(defaultFilterRestRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Метод возвращает список артикулов товаров, у которых не установлена минимальная цена.
     * Метод проверяет именно наличие числа отличного от 0. И не проверяет корректность самой минимальной цены.
     */
    @PostMapping("/product/info/prices/min/no")
    public ResponseEntity<List<String>> getMinimalPrices(@RequestBody DefaultFilterRestRequest defaultFilterRestRequest) {
        log.info("Goods with NO minimal price request: {}", defaultFilterRestRequest);
        List<String> response = productRestService.getNoMinimalPriceGoods(defaultFilterRestRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Получаем информацию о прибыли для каждого товара.
     * Для корректной информации, товар должен быть сохранен в БД и иметь заполненное поле Себестоимость.
     */
    @PostMapping("/product/prices/profit")
    public ResponseEntity<String> getProfit(@RequestBody DefaultFilterRestRequest defaultFilterRestRequest) {
        return null;
    }
}
