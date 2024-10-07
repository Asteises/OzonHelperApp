package ru.asteises.ozonhelperapp.common.json.model.price;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Маркетинговые акции продавца. Параметры date_from, date_to, discount_value и title указываются для каждой акции продавца.
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ActionNode {

    /**
     * Дата и время начала акции продавца.
     */
    @JsonProperty("date_from")
    private LocalDateTime dateFrom;

    /**
     * Дата и время окончания акции продавца.
     */
    @JsonProperty("date_to")
    private LocalDateTime dateTo;

    /**
     * Скидка по акции продавца.
     */
    @JsonProperty("discount_value")
    private String discountValue;

    /**
     * Название акции продавца.
     */
    private String title;
}
