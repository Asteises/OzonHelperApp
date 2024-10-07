package ru.asteises.ozonhelperapp.common.json.model.price;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Список товаров.
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductItemRestResponse {

    /**
     * Максимальная комиссия за эквайринг.
     * <br>
     * Подробнее: <a href="https://seller-edu.ozon.ru/commissions-tariffs/commissions-tariffs-ozon/rashody-na-dop-uslugi#%D1%8D%D0%BA%D0%B2%D0%B0%D0%B8%D1%80%D0%B8%D0%BD%D0%B3">ссылка</a>
     */
    private Integer acquiring;

    @JsonProperty("volume_weight")
    private double volumeWeight;

    /**
     * Идентификатор товара.
     */
    @JsonProperty("product_id")
    private Integer productId;

    /**
     * Идентификатор товара в системе продавца.
     */
    @JsonProperty("offer_id")
    private String offerId;

    /**
     * Цена товара.
     */
    private PriceNodeRestResponse price;

    /**
     * Ценовые индексы товара.
     * <br>
     * Подробнее: <a href="https://seller-edu.ozon.ru/ceny-i-akcii/rabota-s-cenami/price-index">ссылка</a>
     */
    @JsonProperty("price_indexes")
    private PriceIndexesNodeRestResponse priceIndexes;

    /**
     * Информация о комиссиях.
     */
    private CommissionsNode commissions;

    /**
     * Маркетинговые акции продавца.
     */
    @JsonProperty("marketing_actions")
    private MarketingActionsNode marketingActions;

}
