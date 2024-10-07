package ru.asteises.ozonhelperapp.common.json.mapper;

import lombok.NonNull;
import ru.asteises.ozonhelperapp.common.client.model.RequestParams;
import ru.asteises.ozonhelperapp.common.json.model.list.ProductListNodeOzonRestRequestJson;
import ru.asteises.ozonhelperapp.common.json.model.request.impl.DefaultFilterRestRequest;
import ru.asteises.ozonhelperapp.common.json.model.request.impl.DefaultRestRequest;
import ru.asteises.ozonhelperapp.common.json.model.value.ProductListValueOzonRestRequestJson;

import java.util.ArrayList;
import java.util.Set;

public interface RequestMapper {

    static ProductListValueOzonRestRequestJson toRequestValue(@NonNull ProductListNodeOzonRestRequestJson node, String lastId, Integer limit) {
        return ProductListValueOzonRestRequestJson.builder()
                .filter(node)
                .lastId(lastId != null ? lastId : "")
                .limit(limit != null ? limit : 100)
                .build();
    }

    static ProductListNodeOzonRestRequestJson toRequestNode(String visibility) {
        return ProductListNodeOzonRestRequestJson.builder()
                .offerIds(new ArrayList<>())
                .productIds(new ArrayList<>())
                .visibility(visibility != null ? visibility : "ALL")
                .build();
    }

    static ProductListNodeOzonRestRequestJson toRequestNode(Set<String> offerIds, String visibility) {
        return ProductListNodeOzonRestRequestJson.builder()
                .offerIds(offerIds != null ? offerIds.stream().toList() : new ArrayList<>())
                .productIds(new ArrayList<>())
                .visibility(visibility != null ? visibility : "ALL")
                .build();
    }

    static ProductListNodeOzonRestRequestJson toRequestNode(Set<String> offerIds, Set<Integer> productIds, @NonNull String visibility) {
        return ProductListNodeOzonRestRequestJson.builder()
                .offerIds(offerIds != null ? offerIds.stream().toList() : new ArrayList<>())
                .productIds(productIds != null ? productIds.stream().toList() : new ArrayList<>())
                .visibility(visibility.isEmpty() ? visibility : "ALL")
                .build();
    }

    static DefaultFilterRestRequest toDefaultFilterRequest(RequestParams params) {
        return DefaultFilterRestRequest.builder()
                .offerIds(params.getOfferIds())
                .productIds(params.getProductIds())
                .visibility(params.getVisibility().isEmpty() ? "ALL" : params.getVisibility())
                .build();
    }


    static DefaultRestRequest toDefaultRequest(DefaultFilterRestRequest filter, RequestParams params, String lastId) {
        return DefaultRestRequest.builder()
                .filter(filter)
                .limit(params.getLimit() == null ? 100 : params.getLimit())
                .lastId(lastId)
                .build();
    }
}
