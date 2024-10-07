package ru.asteises.ozonhelperapp.common.client.model;

import lombok.*;

import java.util.Set;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestParams {

    private Set<String> offerIds;

    private Set<String> productIds;

    @NonNull
    private String visibility;

    private Integer limit;
}
