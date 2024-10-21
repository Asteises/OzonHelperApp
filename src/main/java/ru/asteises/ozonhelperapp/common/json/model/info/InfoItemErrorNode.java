package ru.asteises.ozonhelperapp.common.json.model.info;

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
public class InfoItemErrorNode {

    /**
     * Код ошибки.
     */
    @JsonProperty("code")
    private String code;

    /**
     * Поле, в котором произошла ошибка.
     */
    @JsonProperty("field")
    private String field;

    /**
     * Атрибут, в котором произошла ошибка.
     */
    @JsonProperty("attribute_id")
    private Integer attributeId;

    /**
     * Состояние товара, в котором произошла ошибка.
     */
    @JsonProperty("state")
    private String state;

    /**
     * Уровень ошибки.
     */
    @JsonProperty("level")
    private String level;

    /**
     * Описание ошибки.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Название атрибута, в котором произошла ошибка.
     */
    @JsonProperty("attribute_name")
    private String attributeName;

    /**
     * Дополнительные поля для описания ошибки.
     */
    @JsonProperty("optional_description_elements")
    private Object optionalDescriptionElements;
}
