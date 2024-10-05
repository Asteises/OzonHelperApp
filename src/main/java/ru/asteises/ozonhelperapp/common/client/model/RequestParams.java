package ru.asteises.ozonhelperapp.common.client.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.Set;

@Builder
@Getter
public class RequestParams {

    private Set<String> offerIds;

    private Set<String> productIds;

    @NonNull
    private String visibility;

    private Integer limit;
}
