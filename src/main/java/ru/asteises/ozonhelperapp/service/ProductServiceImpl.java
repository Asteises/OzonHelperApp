package ru.asteises.ozonhelperapp.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.asteises.ozonhelperapp.ProductMapper;
import ru.asteises.ozonhelperapp.common.client.ClientService;
import ru.asteises.ozonhelperapp.common.client.model.RestResponse;
import ru.asteises.ozonhelperapp.common.json.mapper.RequestMapper;
import ru.asteises.ozonhelperapp.common.json.model.list.ProductListNodeOzonRestRequestJson;
import ru.asteises.ozonhelperapp.common.json.model.list.ProductListNodeOzonRestResultJson;
import ru.asteises.ozonhelperapp.common.json.model.value.ProductListValueOzonRestRequestJson;
import ru.asteises.ozonhelperapp.common.json.model.value.ProductListValueOzonRestResponseJson;
import ru.asteises.ozonhelperapp.common.json.service.JsonService;
import ru.asteises.ozonhelperapp.model.ProductShortNode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ru.asteises.ozonhelperapp.common.client.ApiUri.*;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ClientService clientService;
    private final JsonService jsonService;
    private Map<String, ProductShortNode> productListStorage = new HashMap<>();

    @Override
    public List<ProductShortNode> getProductByVisibilityAll() {
        String uri = getUri(VERSION_2, PRODUCT_LIST);
        return getProductsList(uri, "ALL");
    }

    @Override
    public List<ProductShortNode> getProductByVisibilityArchived() {
        String uri = getUri(VERSION_2, PRODUCT_LIST);
        return getProductsList(uri, "ARCHIVED");
    }

    @Override
    public List<ProductShortNode> getActualProductByVisibilityArchived() {
        String uri = getUri(VERSION_3, PRODUCT_INFO_STOCKS);
        List<ProductShortNode> productShortNodes = getProductsList(uri, "ARCHIVED");
        return null;
    }

    public List<ProductShortNode> getProductsList(String uri, String visibility) {
        ProductListValueOzonRestResponseJson responseResult;
        List<ProductListNodeOzonRestResultJson> allProducts = new ArrayList<>();
        String lastId = null;

        do {
            ProductListNodeOzonRestRequestJson node = RequestMapper.toRequestNode(visibility);
            ProductListValueOzonRestRequestJson body = RequestMapper.toRequestValue(node, lastId, 1000);

            RestResponse response = clientService.sendPostRequest(uri, jsonService.getJsonFromObject(body));
            responseResult = jsonService.parseJsonToDomain(response.getBody(), ProductListValueOzonRestResponseJson.class);

            allProducts.addAll(responseResult.getResult().getItems());
            lastId = responseResult.getResult().getLastId();

        } while (allProducts.size() < responseResult.getResult().getTotal());
        List<ProductShortNode> result = ProductMapper.map(allProducts);
        saveProductList(result);
        return result;
    }

    public Set<Integer> getAllProductIdsInArchive() {
        return productListStorage.values().stream()
                .filter(ProductShortNode::getArchived)
                .map(ProductShortNode::getProductId)
                .collect(Collectors.toSet());
    }

    /**
     * Метод находит все offer_id товаров, которые числятся в архиве.
     * После чего создает тело запроса для Озон и получает остатки для этих товаров.
     * Возвращаем список offer_id для товаров с ненулевым остатком.
     */
    public Set<Integer> getAllAvailableProductIdsInArchive() {
        Set<String> productOfferIdsInArchive = productListStorage.values().stream()
                .filter(ProductShortNode::getArchived)
                .map(ProductShortNode::getOfferId)
                .collect(Collectors.toSet());
        String uri = getUri(VERSION_3, PRODUCT_INFO_STOCKS);
        ProductListValueOzonRestRequestJson requestObject = getRequestBody(productOfferIdsInArchive);
        String body = jsonService.getJsonFromObject(requestObject);
        RestResponse response = clientService.sendPostRequest(uri, body);
        return null;
    }

    private ProductListValueOzonRestRequestJson getRequestBody(String visibility) {
        ProductListNodeOzonRestRequestJson node = RequestMapper.toRequestNode(visibility);
        return RequestMapper.toRequestValue(node, "", 1000);
    }

    private ProductListValueOzonRestRequestJson getRequestBody(Set<String> offerIds) {
        ProductListNodeOzonRestRequestJson node = RequestMapper.toRequestNode(offerIds, "");
        return RequestMapper.toRequestValue(node, "", 1000);
    }

    //TODO Private
    public void saveProductList(List<ProductShortNode> productShortNodes) {
        productListStorage = productShortNodes.stream()
                .collect(Collectors.toMap(ProductShortNode::getOfferId, Function.identity()));
    }

//    public List<ProductInfoNode> getProductInfoList() {
//        String uri = getUri(PRODUCT_INFO_LIST);
//        // Из БД взять все offer_id или product_id или sku.
//    }
}
