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
public class InfoCommissionNode {

    /**
     * Стоимость доставки.
     */
    @JsonProperty("delivery_amount")
    private Double deliveryAmount;

    /**
     * Процент комиссии.
     */
    @JsonProperty("percent")
    private Double percent;

    /**
     * Стоимость возврата.
     */
    @JsonProperty("return_amount")
    private Double returnAmount;

    /**
     * Сумма комиссии.
     */
    @JsonProperty("value")
    private Double value;

    /**
     * Схема продажи.
     */
    @JsonProperty("sale_schema")
    private String saleSchema;
}
