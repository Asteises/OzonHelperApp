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
public class PriceNodeRestResponse {

    /**
     * Валюта ваших цен. Совпадает с валютой, которая установлена в настройках личного кабинета.
     */
    @JsonProperty("currency_code")
    private String currencyCode;

    /**
     * Цена товара с учётом скидок — это значение показывается на карточке товара.
     */
    private String price;

    /**
     * Цена до учёта скидок. На карточке товара отображается зачёркнутой.
     */
    @JsonProperty("old_price")
    private String oldPrice;

    /**
     * Цена поставщика.
     */
    @JsonProperty("retail_price")
    private String retailPrice;

    /**
     * Ставка НДС для товара.
     */
    private String vat;

    /**
     * Минимальная цена на аналогичный товар на Ozon.
     */
    @JsonProperty("min_ozon_price")
    private String minOzonPrice;

    /**
     * Цена на товар с учетом всех акций. Это значение будет указано на витрине Ozon.
     */
    @JsonProperty("marketing_price")
    private String marketingPrice;

    /**
     * Цена на товар с учетом акций продавца.
     */
    @JsonProperty("marketing_seller_price")
    private String marketingSellerPrice;

    /**
     * Если автоприменение акций у товара включено — true
     */
    @JsonProperty("auto_action_enabled")
    private boolean autoActionEnabled;
}
