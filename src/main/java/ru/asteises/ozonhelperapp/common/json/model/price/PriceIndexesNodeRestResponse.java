package ru.asteises.ozonhelperapp.common.json.model.price;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PriceIndexesNodeRestResponse {

    /**
     * Цена товара у конкурентов на других площадках.
     */
    @JsonProperty("external_index_data")
    private PriceIndexData externalIndexData;

    /**
     * Цена товара у конкурентов на Ozon.
     */
    @JsonProperty("ozon_index_data")
    private PriceIndexData ozonIndexData;

    /**
     * Цена вашего товара на других площадках.
     */
    @JsonProperty("self_marketplaces_index_data")
    private PriceIndexData selfMarketplacesIndexData;

    /**
     * Итоговый ценовой индекс товара:
     * <br>
     * WITHOUT_INDEX — без индекса,
     * PROFIT — выгодный,
     * AVG_PROFIT — умеренный,
     * NON_PROFIT — невыгодный.
     */
    @JsonProperty("price_index")
    private String priceIndex;
}
