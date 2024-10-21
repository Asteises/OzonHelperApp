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
public class InfoSourcesNode {

    /**
     * Признак, что источник учитывается при расчете рыночного значения.
     */
    @JsonProperty("is_enabled")
    private Boolean enabled;

    /**
     * Идентификатор товара на Ozon.
     */
    private Integer sku;

    /**
     * Ссылка на источник.
     */
    private String source;
}
