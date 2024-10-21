package ru.asteises.ozonhelperapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.asteises.ozonhelperapp.common.json.model.info.InfoValueRestResponse;
import ru.asteises.ozonhelperapp.common.json.model.request.impl.InfoProductRestRequest;
import ru.asteises.ozonhelperapp.service.impl.ProductRestService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product/info")
public class InfoController {

    private final ProductRestService productRestService;

    /**
     * Информация о товаре FIXME уточнить, можно ли отправлять в запросе несколько артикулов?
     */
    @PostMapping("/")
    public ResponseEntity<InfoValueRestResponse> getProductInfo(@RequestBody InfoProductRestRequest request) {
        return ResponseEntity.ok(productRestService.getProductInfo(request));
    }
}
