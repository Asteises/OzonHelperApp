package ru.asteises.ozonhelperapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.asteises.ozonhelperapp.common.client.model.RestResponse;
import ru.asteises.ozonhelperapp.model.ProductShortNode;
import ru.asteises.ozonhelperapp.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class OzonHelperController {

    // Вначале реализовать все стандартные методы
    private final ProductService productService;

    /**
     * Запрашиваем все товары в сокращенном виде из ЛК.
     */
    @PostMapping("/product/list")
    public ResponseEntity<String> getProductList() {
        List<ProductShortNode> productShortNodes = productService.getProductByVisibilityAll();
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    /**
     * Возвращаем все id товаров в архиве, у которых не нулевой остаток.
     */
    @GetMapping("/product/archive/list/available")
    public ResponseEntity<String> getAvailableProductArchiveList() {
        return null;
    }

    @PostMapping("/product/info")
    public ResponseEntity<RestResponse> getProductInfo() {
//        String uri = "/v2/product/info";
//        RestResponse response = clientService.sendPostRequest(uri);
//        ProductListValueOzonRestResultJson result = jsonService.parseJsonToDomain(response.getContent(), ProductListValueOzonRestResultJson.class);
//
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/product/info/list")
    public ResponseEntity<RestResponse> getProductInfoList() {
//        String uri = "/v2/product/info";
//        RestResponse response = clientService.sendPostRequest(uri);
//        ProductListValueOzonRestResultJson result = jsonService.parseJsonToDomain(response.getContent(), ProductListValueOzonRestResultJson.class);
//
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
