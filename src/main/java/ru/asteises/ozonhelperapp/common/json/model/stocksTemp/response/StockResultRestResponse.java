package ru.asteises.ozonhelperapp.common.json.model.stocksTemp.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.asteises.ozonhelperapp.common.json.model.OzonRestResponse;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StockResultRestResponse implements OzonRestResponse<StockItemRestResponse> {

    private List<StockItemRestResponse> items;

    private Integer total;

    @JsonProperty("last_id")
    private String lastId;

    @Override
    public List<StockItemRestResponse> getItems() {
        return items;
    }

    @Override
    public void setItems(List<StockItemRestResponse> items) {
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
