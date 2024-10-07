package ru.asteises.ozonhelperapp.common.json.model.list;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.asteises.ozonhelperapp.common.json.model.response.OzonRestResponse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Request: /v2/product/info
 * <br>
 * Общий блок получаемый из запроса. По умолчанию вернет список всех товаров.
 * <br>
 * total - общее количество товаров в списке, но в одном запросе приходит максимум 1000.
 * <br>
 * lastId - Идентификатор последнего значения на странице. Оставьте это поле пустым при выполнении первого запроса.
 * Чтобы получить следующие значения, укажите last_id из ответа предыдущего запроса.
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductListOzonRestResponseJson implements OzonRestResponse<ProductListNodeOzonRestResultJson> {

    private List<ProductListNodeOzonRestResultJson> items = new LinkedList<>();

    private Integer total;

    @JsonProperty("last_id")
    private String lastId;

    @Override
    public List<ProductListNodeOzonRestResultJson> getItems() {
        return items;
    }

    @Override
    public void setItems(List<ProductListNodeOzonRestResultJson> items) {
        this.items = new ArrayList<>(items);
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
