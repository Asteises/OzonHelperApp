package ru.asteises.ozonhelperapp;

import ru.asteises.ozonhelperapp.common.json.model.list.ProductListNodeOzonRestResultJson;
import ru.asteises.ozonhelperapp.model.impl.DefaultProductShortNodeDomain;
import ru.asteises.ozonhelperapp.model.ProductShortNode;

import java.util.List;
import java.util.stream.Collectors;

public interface ProductMapper {

    static ProductShortNode map(ProductListNodeOzonRestResultJson restNode) {
        return DefaultProductShortNodeDomain.builder()
                .productId(restNode.getProductId())
                .offerId(restNode.getOfferId())
                .fboVisible(restNode.isFboVisible())
                .fbsVisible(restNode.isFbsVisible())
                .archived(restNode.isArchived())
                .discounted(restNode.isDiscounted())
                .build();
    }

    static List<ProductShortNode> map(List<ProductListNodeOzonRestResultJson> restNodes) {
        return restNodes.stream()
                .map(ProductMapper::map)
                .collect(Collectors.toList());
    }
}
