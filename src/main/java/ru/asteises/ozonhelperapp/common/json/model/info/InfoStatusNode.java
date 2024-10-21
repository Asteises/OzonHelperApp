package ru.asteises.ozonhelperapp.common.json.model.info;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InfoStatusNode {

    /**
     * Состояние товара.
     */
    @JsonProperty("state")
    private String state;

    /**
     * Состояние товара, на переходе в которое произошла ошибка.
     */
    @JsonProperty("state_failed")
    private String stateFailed;

    /**
     * Статус модерации.
     */
    @JsonProperty("moderate_status")
    private String moderateStatus;

    /**
     * Причины отклонения товара.
     */
    @JsonProperty("decline_reasons")
    private List<String> declineReasons;

    @JsonSetter("decline_reasons")
    public void setDeclineReasons(List<String> declineReasons) {
        if (declineReasons != null) {
            this.declineReasons = new ArrayList<>(declineReasons);
        }
    }

    @JsonGetter("decline_reasons")
    public List<String> getDeclineReasons() {
        return Objects.requireNonNullElseGet(declineReasons, ArrayList::new);
    }

    /**
     * Статус валидации.
     */
    @JsonProperty("validation_state")
    private String validationState;

    /**
     * Название состояния товара.
     */
    @JsonProperty("state_name")
    private String stateName;

    /**
     * Описание состояния товара.
     */
    @JsonProperty("state_description")
    private String stateDescription;

    /**
     * Признак, что при создании товара возникли ошибки.
     */
    @JsonProperty("is_failed")
    private Boolean failed;

    /**
     * Признак, что товар создан.
     */
    @JsonProperty("is_created")
    private Boolean created;

    /**
     * Подсказки для текущего состояния товара.
     */
    @JsonProperty("state_tooltip")
    private String stateTooltip;

    /**
     * Время последнего изменения состояния товара.
     */
    @JsonProperty("state_updated_at")
    private ZonedDateTime stateUpdatedAt;

    /**
     * Ошибки при загрузке товаров.
     */
    @JsonProperty("item_errors")
    private List<InfoItemErrorNode> itemErrors;

    @JsonSetter("item_errors")
    public void setItemErrors(List<InfoItemErrorNode> itemErrors) {
        if (itemErrors != null) {
            this.itemErrors = new ArrayList<>(itemErrors);
        }
    }

    @JsonGetter("item_errors")
    public List<InfoItemErrorNode> getItemErrors() {
        return Objects.requireNonNullElseGet(itemErrors, ArrayList::new);
    }
}
