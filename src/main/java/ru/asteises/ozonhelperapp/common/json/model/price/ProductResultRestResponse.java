package ru.asteises.ozonhelperapp.common.json.model.price;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.asteises.ozonhelperapp.common.json.model.response.OzonRestResponse;

import java.util.List;

/**
 * Результаты запроса.
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductResultRestResponse implements OzonRestResponse<ProductItemRestResponse> {

    /**
     * Список товаров.
     */
    private List<ProductItemRestResponse> items;

    /**
     * Идентификатор последнего значения на странице.
     * <br>
     * Чтобы получить следующие значения, передайте полученное значение в следующем запросе в параметре last_id.
     */
    @JsonProperty("last_id")
    private String lastId;

    /**
     * Количество товаров в списке.
     */
    private Integer total;


    @Override
    public List<ProductItemRestResponse> getItems() {
        return items;
    }

    @Override
    public void setItems(List<ProductItemRestResponse> items) {
        this.items = items;
    }

    @Override
    public Integer getTotal() {
        return total;
    }

    @Override
    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String getLastId() {
        return lastId;
    }

    @Override
    public void setLastId(String lastId) {
        this.lastId = lastId;
    }
}
