package ru.asteises.ozonhelperapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.asteises.ozonhelperapp.common.client.model.RequestParams;
import ru.asteises.ozonhelperapp.common.json.model.stock.response.StockValueRestResponse;
import ru.asteises.ozonhelperapp.service.impl.StockRestService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product/info/stocks")
public class StockController {

    private final StockRestService stockRestService;

    @PostMapping("/")
    public ResponseEntity<StockValueRestResponse> getAllStocks(@RequestBody RequestParams params) {
        return new ResponseEntity<>(stockRestService.getProductInfoStocks(params), HttpStatus.OK);
    }

    @PostMapping("/available")
    public ResponseEntity<Map<String, Map<String, Integer>>> getAvailableStocks(@RequestBody RequestParams params) {
        return new ResponseEntity<>(stockRestService.getProductNotZeroQuantityStocks(params), HttpStatus.OK);
    }
}
