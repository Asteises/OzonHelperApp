package ru.asteises.ozonhelperapp.common.json.model.info;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InfoVisibilityDetailsNode {

    /**
     * Если установлена цена — true.
     */
    @JsonProperty("has_price")
    private Boolean hasPrice;

    /**
     * Если есть остаток на складах — true.
     */
    @JsonProperty("has_stock")
    private Boolean hasStock;

    /**
     * Если активный товар — true.
     */
    @JsonProperty("active_product")
    private Boolean activeProduct;
}
