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
import java.util.List;

/**
 * Маркетинговые акции продавца.
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MarketingActionsNode {

    /**
     * Дата и время начала текущего периода по всем действующим акциям.
     */
    @JsonProperty("current_period_from")
    private LocalDateTime currentPeriodFrom;

    /**
     * Дата и время окончания текущего периода по всем действующим акциям.
     */
    @JsonProperty("current_period_to")
    private LocalDateTime currentPeriodTo;

    /**
     * Если к товару может быть применена акция за счёт Ozon — true.
     */
    @JsonProperty("ozon_actions_exist")
    private Boolean ozonActionsExist;

    /**
     * Маркетинговые акции продавца.
     */
    private List<ActionNode> actions;
}
