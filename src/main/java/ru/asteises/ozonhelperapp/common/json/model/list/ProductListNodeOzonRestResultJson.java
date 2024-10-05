package ru.asteises.ozonhelperapp.common.json.model.list;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Request: /v2/product/info
 * <br>
 * Класс для реализации стандартного блока с краткой информацией о товаре, полученного при запросе всех товаров из ЛК.
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductListNodeOzonRestResultJson {

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("offer_id")
    private String offerId;

    @JsonProperty("is_fbo_visible")
    private boolean fboVisible;

    @JsonProperty("is_fbs_visible")
    private boolean fbsVisible;

    @JsonProperty("archived")
    private boolean archived;

    @JsonProperty("is_discounted")
    private boolean discounted;
}
